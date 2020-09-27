package com.airstay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.airstay.domain.Customer;
import com.airstay.repository.CustomerRepository;
import com.airstay.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sarwo.wibowo
 *
 */
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer create(String firstName, String lastName, String mobilePhone) {
		
		log.info("Request to create customer data");
		
		//TODO : do validation
		
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setMobilePhone(mobilePhone);
		
		customerRepository.save(customer);
		
		log.info("Customer data created {} ", customer);
		return customer;
	}

	@Override
	public Customer getByMobilePhone(String mobilePhone) {
		return customerRepository.findByMobilePhone(mobilePhone);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

}
