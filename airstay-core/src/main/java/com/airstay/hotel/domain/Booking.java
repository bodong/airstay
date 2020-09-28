package com.airstay.hotel.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

/**
 * @author sarwo.wibowo
 *
 */
@Data
@Document
@ToString
public class Booking {
	@Id
	private String id;
	
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private String customerEmail;
	private String hotelCode;
	private String roomCode;
	
	private int totalGuests = 0;
	private double totalAmount;
	
}
