package com.airstay.hotel.rest.request;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sarwo.wibowo
 *
 */
@Setter
@Getter
public class MakeBookingRequest {
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private String customerEmail;
	private String hotelCode;
	private String roomCode;
	
	private int totalGuests = 0;
}
