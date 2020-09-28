package com.airstay.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.airstay.customer.rest.dto.CustomerDto;
import com.airstay.customer.service.CustomerService;
import com.airstay.hotel.domain.Booking;
import com.airstay.hotel.mapper.BookingMapper;
import com.airstay.hotel.repository.BookingRepository;
import com.airstay.hotel.rest.dto.BookingDto;
import com.airstay.hotel.rest.dto.HotelDto;
import com.airstay.hotel.rest.dto.RoomDto;
import com.airstay.hotel.rest.request.MakeBookingRequest;
import com.airstay.hotel.service.BookingService;
import com.airstay.hotel.service.CalculatorService;
import com.airstay.hotel.service.HotelService;
import com.airstay.hotel.service.RoomService;
import com.google.common.base.Preconditions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sarwo.wibowo
 *
 */
@Slf4j
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CalculatorService calculatorService;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomService roomService;
	
	@Override
	public BookingDto makeBooking(MakeBookingRequest request) {
		validateInput(request);
		
		log.info("Request to make a booking");

		CustomerDto customer = customerService.getByEmail(request.getCustomerEmail());
		Preconditions.checkState(customer != null, "No customer found for email %s", request.getCustomerEmail());
		
		HotelDto hotel = hotelService.getByCode(request.getHotelCode());
		Preconditions.checkState(hotel != null, "No hotel found for code %s", request.getHotelCode());
		
		RoomDto room = roomService.getByCode(request.getRoomCode());
		Preconditions.checkState(room != null, "No room found for code %s", request.getRoomCode());
		
		long totalStay = calculatorService.calculateGapDays(request.getCheckIn(), request.getCheckOut());

		//TODO : validate if customer order same booking
		
		double totalAmount = room.getPricePerNight() * totalStay;
		
		Booking booking = toBooking(request, totalAmount);
		bookingRepository.save(booking);
		
		log.info("Booking created {} ", booking);
		
		BookingDto bookingDto = BookingMapper.INSTANCE.entityToDto(booking);
		enrichOtherInfo(customer, hotel, room, totalStay, bookingDto);
		
		return bookingDto;
	}

	@Override
	public List<BookingDto> getByCustomerEmail(String customerEmail) {
		
		List<Booking> bookings = bookingRepository.findAllByCustomerEmail(customerEmail);
		List<BookingDto> bookingDtos = BookingMapper.INSTANCE.entitiesToDtos(bookings);
		
		return bookingDtos;
	}
	
	@Override
	public void dropAll() {
		bookingRepository.deleteAll();
	}

	private void enrichOtherInfo(CustomerDto customer, HotelDto hotel, RoomDto room, long totalStay, BookingDto bookingDto) {
		bookingDto.setTotalStay(totalStay);
		bookingDto.setHotel(hotel);
		bookingDto.setRoom(room);
		bookingDto.setCustomer(customer);
	}
	
	private Booking toBooking(MakeBookingRequest request, double totalAmount) {
		Booking booking = new Booking();
		booking.setCheckIn(request.getCheckIn());
		booking.setCheckOut(request.getCheckOut());
		booking.setCustomerEmail(request.getCustomerEmail());
		booking.setHotelCode(request.getHotelCode());
		booking.setRoomCode(request.getRoomCode());
		booking.setTotalAmount(totalAmount);
		booking.setTotalGuests(request.getTotalGuests());
		return booking;
	}

	private void validateInput(MakeBookingRequest request) {
		Preconditions.checkArgument(request != null, "Request is required");
		Preconditions.checkArgument(request.getCheckIn() != null, "Check-in is required");
		Preconditions.checkArgument(request.getCheckOut() != null, "Check-out date is required");
		Preconditions.checkArgument(request.getCheckIn().isBefore(request.getCheckOut()), "Check-in date, cannot be later than check-out date");
		Preconditions.checkArgument(request.getCustomerEmail() != null, "Customer email is required");
		Preconditions.checkArgument(request.getHotelCode() != null, "Hotel code is required");
		Preconditions.checkArgument(request.getRoomCode() != null, "Room code is required");
		Preconditions.checkArgument(request.getTotalGuests() > 0, "At least one guest is required");
	}


}
