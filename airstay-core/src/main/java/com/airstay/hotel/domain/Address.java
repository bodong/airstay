package com.airstay.hotel.domain;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
	
	@Id
	private String id;
	private String street;
	private String city;
	private String country;
}
