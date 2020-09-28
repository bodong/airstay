package com.airstay.customer.rest.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sarwo.wibowo
 *
 */
@Getter
@Setter
public class CreateCustomerRequest {
	private String firstName;
	private String lastName;
	private String mobilePhone;
	private String email;
}
