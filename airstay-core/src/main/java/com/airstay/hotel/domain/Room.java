package com.airstay.hotel.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sarwo.wibowo
 *
 */
@Getter
@Setter
@ToString
public class Room {
	private String id;
	private String code;
	private String name;
	private String hotelCode;
	private boolean smooking;
	private Double pricePerNight;
}
