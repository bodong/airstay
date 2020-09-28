package com.airstay.hotel.rest.dto;

import com.airstay.common.rest.response.Payload;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sarwo.wibowo
 *
 */
@Getter
@Setter
public class RoomDto implements Payload {
	private String id;
	private String code;
	private String name;
	private String hotelCode;
	private boolean smooking;
	private Double pricePerNight;
}
