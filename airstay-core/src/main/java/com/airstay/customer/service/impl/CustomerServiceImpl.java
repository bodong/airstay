package com.airstay.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.airstay.common.util.EmailValidator;
import com.airstay.customer.domain.Customer;
import com.airstay.customer.mapper.CustomerMapper;
import com.airstay.customer.repository.CustomerRepository;
import com.airstay.customer.rest.dto.CustomerDto;
import com.airstay.customer.service.CustomerService;
import com.google.common.base.Preconditions;

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
	public CustomerDto register(String firstName, String lastName, String mobilePhone, String email) {
		
		validateInput(firstName, mobilePhone, email);
		
		log.info("Request to create customer data");
		Customer customer = new Customer();
		toCustomer(firstName, lastName, mobilePhone, email, customer);
		
		customerRepository.save(customer);
		
		log.info("Customer data created {} ", customer);
		return CustomerMapper.INSTANCE.entityToDto(customer);
	}

	@Override
	public CustomerDto getByMobilePhone(String mobilePhone) {
		Customer customer = customerRepository.findByMobilePhone(mobilePhone);
		return CustomerMapper.INSTANCE.entityToDto(customer);
	}

	@Override
	public List<CustomerDto> getAll() {
		List<Customer> customers =  customerRepository.findAll();
		return CustomerMapper.INSTANCE.entitiesToDtos(customers);
	}

	@Override
	public void dropAll() {
		customerRepository.deleteAll();
	}
	
	@Override
	public CustomerDto getByEmail(String email) {
		Customer customer = customerRepository.findByEmail(email);
		return CustomerMapper.INSTANCE.entityToDto(customer);
	}
	
	private boolean validEmail(String email) {
		return EmailValidator.validEmail(email);
	}

	private void toCustomer(String firstName, String lastName, String mobilePhone, String email, Customer customer) {
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setMobilePhone(mobilePhone);
		customer.setEmail(email);
	}
	
	private void validateInput(String firstName, String mobilePhone, String email) {
		Preconditions.checkArgument(!StringUtils.isEmpty(firstName), "First name is required");
		Preconditions.checkArgument(!StringUtils.isEmpty(mobilePhone), "Mobile phone is required");
		Preconditions.checkArgument(validEmail(email), "Valid email is required");
	}

}
