package com.airstay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airstay.controller.request.CreateCustomerRequest;
import com.airstay.domain.Customer;
import com.airstay.service.CustomerService;

import lombok.NonNull;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer createData(@RequestBody @NonNull CreateCustomerRequest customer) {
		Customer createdCustomer = customerService.create(customer.getFirstName(), customer.getLastName(), customer.getMobilePhone());
		return createdCustomer;
	}
	
	@GetMapping
	public List<Customer> getAll() {
		return customerService.getAll();
	}
}
