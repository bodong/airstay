package com.airstay.service;

import java.util.List;

import com.airstay.rest.controller.dto.CustomerDto;

/**
 * @author sarwo.wibowo
 *
 */
public interface CustomerService {
	CustomerDto create(String firstName, String lastName, String mobilePhone);
	
	CustomerDto getByMobilePhone(String mobilePhone);

	List<CustomerDto> getAll();
}
