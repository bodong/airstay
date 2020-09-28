package com.airstay.hotel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.airstay.customer.rest.dto.CustomerDto;
import com.airstay.customer.service.CustomerService;
import com.airstay.hotel.domain.Booking;
import com.airstay.hotel.domain.Room;
import com.airstay.hotel.repository.BookingRepository;
import com.airstay.hotel.repository.RoomRepository;
import com.airstay.hotel.rest.dto.BookingDto;
import com.airstay.hotel.rest.dto.HotelDto;
import com.airstay.hotel.rest.dto.RoomDto;
import com.airstay.hotel.rest.request.MakeBookingRequest;
import com.airstay.hotel.service.impl.BookingServiceImpl;
import com.airstay.hotel.service.impl.RoomServiceImpl;

/**
 * @author sarwo.wibowo
 *
 */
public class BookingServiceTest {

	@InjectMocks
	private BookingServiceImpl bookingService;

	@Mock
	private BookingRepository bookingRepository;

	@Mock
	private CalculatorService calculatorService;

	@Mock
	private CustomerService customerService;

	@Mock
	private HotelService hotelService;

	@Mock
	private RoomService roomService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void dropAll() {
		bookingService.dropAll();
		verify(bookingRepository, times(1)).deleteAll();
	}

	@Test
	public void getByCustomerEmail() {
		String email = "foo@dummy.com";

		List<Booking> bookings = new ArrayList<>();
		bookings.add(mockBooking(email));
		when(bookingRepository.findAllByCustomerEmail(email)).thenReturn(bookings);

		bookingService.getByCustomerEmail(email);

		verify(bookingRepository, times(1)).findAllByCustomerEmail(email);
	}

	@Test
	public void makeBooking() {

		LocalDate checkIn = LocalDate.parse("2020-09-22");
		LocalDate checkOut = LocalDate.parse("2020-09-24");
		MakeBookingRequest request = toRequest("pandir@dummy.com", "HK", "RKH", checkIn, checkOut, 2);

		CustomerDto mockCustomer = mockCustomer(request.getCustomerEmail());
		when(customerService.getByEmail(request.getCustomerEmail())).thenReturn(mockCustomer);

		HotelDto mockHotel = mockHotel(request.getHotelCode());
		when(hotelService.getByCode(request.getHotelCode())).thenReturn(mockHotel);

		RoomDto mockRoom = mockRoom(request.getRoomCode(), request.getHotelCode());
		when(roomService.getByCode(request.getRoomCode())).thenReturn(mockRoom);

		double totalPrice = 200;
		long stay = 2l;
		when(calculatorService.calculateGapDays(checkIn, checkOut)).thenReturn(stay);
		when(calculatorService.calculateTotalPrice(mockRoom.getPricePerNight(), stay)).thenReturn(totalPrice);

		Booking mockBooking = mockBooking(request.getCustomerEmail(), request.getHotelCode(), request.getRoomCode(),
				request.getTotalGuests(), request.getCheckIn(), request.getCheckOut(), totalPrice);

		when(bookingRepository.save(any(Booking.class))).thenReturn(mockBooking);
		
		BookingDto booking =  bookingService.makeBooking(request);
		
		assertNotNull(booking);

	}

	private RoomDto mockRoom(String roomCode, String hotelCode) {
		RoomDto dto = new RoomDto();
		dto.setCode(roomCode);
		dto.setHotelCode(hotelCode);
		dto.setPricePerNight(200.0);
		return dto;
	}

	private HotelDto mockHotel(String hotelCode) {
		HotelDto dto = new HotelDto();
		dto.setCode(hotelCode);
		return dto;
	}

	private CustomerDto mockCustomer(String customerEmail) {
		CustomerDto dto = new CustomerDto();
		dto.setEmail(customerEmail);
		return dto;
	}

	private MakeBookingRequest toRequest(String email, String hotelCode, String roomCode, LocalDate checkIn,
			LocalDate checkOut, int totalGuests) {

		MakeBookingRequest request = new MakeBookingRequest();
		request.setCheckIn(checkIn);
		request.setCheckOut(checkOut);
		request.setCustomerEmail(email);
		request.setHotelCode(hotelCode);
		request.setRoomCode(roomCode);
		request.setTotalGuests(totalGuests);
		return request;
	}

	private Booking mockBooking(String email) {
		Booking booking = new Booking();
		return booking;
	}

	private Booking mockBooking(String customerEmail, String hotelCode, String roomCode, int totalGuests,
			LocalDate checkIn, LocalDate checkOut, double totalAmount) {
		Booking booking = mockBooking(customerEmail);
		booking.setCheckIn(checkIn);
		booking.setCheckOut(checkOut);
		booking.setHotelCode(hotelCode);
		booking.setRoomCode(roomCode);
		booking.setTotalGuests(totalGuests);
		booking.setTotalAmount(totalAmount);
		return null;
	}
}
