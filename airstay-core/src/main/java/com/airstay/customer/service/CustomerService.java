package com.airstay.customer.service;

import java.util.List;

import com.airstay.customer.rest.dto.CustomerDto;

/**
 * @author sarwo.wibowo
 *
 */
public interface CustomerService {
	CustomerDto register(String firstName, String lastName, String mobilePhone, String email);
	
	CustomerDto getByMobilePhone(String mobilePhone);
	
	CustomerDto getByEmail(String email);

	List<CustomerDto> getAll();

	void dropAll();
}
