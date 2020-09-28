package com.airstay.hotel.rest.dto;

import java.time.LocalDate;

import com.airstay.common.rest.response.Payload;
import com.airstay.customer.rest.dto.CustomerDto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sarwo.wibowo
 *
 */
@Getter
@Setter
public class BookingDto implements Payload {
	private String id;

	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private CustomerDto customer;
	
	private HotelDto hotel;
	private RoomDto room;
	
	private int totalGuests = 0;
	private long totalStay = 0;
	private double totalAmount;
	
	
}
