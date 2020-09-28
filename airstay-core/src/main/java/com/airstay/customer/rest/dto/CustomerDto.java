package com.airstay.customer.rest.dto;

import com.airstay.common.rest.response.Payload;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sarwo.wibowo
 *
 */
@Getter
@Setter
public class CustomerDto implements Payload {
	private String id;
	private String firstName;
	private String email;
	private String lastName;
	private String mobilePhone;
}
