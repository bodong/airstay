package com.airstay.service;

import java.util.List;

import com.airstay.domain.Customer;

/**
 * @author sarwo.wibowo
 *
 */
public interface CustomerService {
	Customer create(String firstName, String lastName, String mobilePhone);
	
	Customer getByMobilePhone(String mobilePhone);

	List<Customer> getAll();
}
