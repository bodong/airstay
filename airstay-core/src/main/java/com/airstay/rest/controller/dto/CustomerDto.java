package com.airstay.rest.controller.dto;

import com.airstay.rest.response.Payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto implements Payload {
	private String id;
	private String firstName;
	private String email;
	private String lastName;
	private String mobilePhone;
}
