package com.airstay.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@Document
@ToString(exclude = {"lastName"})
public class Customer {
	
	@Id
	private  String id;
	
	private String firstName;
	
	private String email;
	
	private String lastName;
	
	private String mobilePhone;

}
