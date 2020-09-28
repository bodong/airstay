package com.airstay.hotel.rest.dto;


import com.airstay.common.rest.response.Payload;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sarwo.wibowo
 *
 */
@Setter
@Getter
public class HotelDto implements Payload {
	private String id;
	private String code;
	private String name;
	
	private AddressDto address;
}
