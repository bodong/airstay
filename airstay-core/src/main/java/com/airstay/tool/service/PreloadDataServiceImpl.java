package com.airstay.tool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import com.airstay.customer.service.CustomerService;
import com.airstay.hotel.domain.Address;
import com.airstay.hotel.rest.dto.HotelDto;
import com.airstay.hotel.service.BookingService;
import com.airstay.hotel.service.HotelService;
import com.airstay.hotel.service.RoomService;
import com.airstay.tool.PreloadDataService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sarwo.wibowo
 *
 */
@Slf4j
public class PreloadDataServiceImpl implements PreloadDataService {

	@Autowired
	private Environment environment;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookingService bookingService;
	
	@Override
	public void createData() {
		
		if(!setupData()) {
			return;
		}
		
		log.info("Creating initial data");
		cleanupData();
		
		HotelDto shangrila = createHotel("Shangri-La Hotel", "SLH", "KL Street 1", "Kuala Lumpur", "Malaysia" );
		createRoom(shangrila.getCode(), "DELUX001", "Deluxe", false, 350.0);
		createRoom(shangrila.getCode(), "DELUX002", "Deluxe", true, 300.0);
		createRoom(shangrila.getCode(), "STD001", "Standard", false, 250.0);
		createRoom(shangrila.getCode(), "STD002", "Standard", true, 200.0);
		
		
		HotelDto leMeridien = createHotel("Le Meridien Hotel", "LMH", "KL Street 2", "Kuala Lumpur", "Malaysia" );
		createRoom(leMeridien.getCode(), "DELUX001", "Deluxe", false, 450.0);
		createRoom(leMeridien.getCode(), "DELUX002", "Deluxe", true, 350.0);
		createRoom(leMeridien.getCode(), "STD001", "Standard", false, 300.0);
		
		
		HotelDto pullman = createHotel("Pullman Hotel", "PLM", "Putrajaya Street 1", "Putrajaya", "Malaysia" );
		createRoom(pullman.getCode(), "DELUX001", "Deluxe", false, 250.0);
		createRoom(pullman.getCode(), "DELUX002", "Deluxe", true, 200.0);

		createCustomer("Rod", "Johnson", "rod@spring.io", "911");
		createCustomer("Tonny", "Robbins", "tonny@robbins.com", "112");
		
		log.info("Initial Data created");
	}

	private void createCustomer(String firstName, String lastName, String email, String mobilePhone) {
		customerService.register(firstName, lastName, mobilePhone, email);
	}

	private void createRoom(String hotelCode, String roomCode, String roomName, boolean smookingRoom, double price) {
		StringBuilder sb = new StringBuilder();
		sb.append(hotelCode).append("-").append(roomCode);
		roomService.create(sb.toString(), roomName, hotelCode, smookingRoom, price);
	}

	private void cleanupData() {
		hotelService.dropAll();
		roomService.dropAll();
		customerService.dropAll();
		bookingService.dropAll();
	}

	private boolean setupData() {
		String setupData = environment.getProperty("data");
		return !StringUtils.isEmpty(setupData) && "true".equalsIgnoreCase(setupData);
	}

	private HotelDto createHotel(String hotelName, String hotelCode, String street, String city, String country) {
		Address address = toAddress(street, city, country);
		HotelDto hotelDto = hotelService.create(hotelCode, hotelName, address);
		return hotelDto;
	}

	private Address toAddress(String street, String city, String country) {
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setCountry(country);
		return address;
	}

}
