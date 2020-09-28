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
public class AddressDto implements Payload {
	private String id;
	private String street;
	private String city;
	private String country;
}
