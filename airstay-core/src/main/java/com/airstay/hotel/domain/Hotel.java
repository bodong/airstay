package com.airstay.hotel.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Document
@ToString(exclude = {"address"})
public class Hotel {
	
	@Id
	private String id;
	private String code;
	private String name;
	
	private Address address;
}
