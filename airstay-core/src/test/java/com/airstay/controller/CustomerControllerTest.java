package com.airstay.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.airstay.controller.request.CreateCustomerRequest;
import com.airstay.domain.Customer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate rest;

	private String URL;

	@PostConstruct
	void setUp() {
		URL = "http://localhost:" + port + "/api/v1";

	}

	@Test
	public void getCustomers() {

		ResponseEntity<List<Customer>> data = rest.exchange(URL + "/customers", HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {});
		assertTrue(data.getStatusCode().equals(HttpStatus.OK));

	}

	@Test
	public void createCustomer() {
		CreateCustomerRequest request = new CreateCustomerRequest();
		request.setFirstName("Michael");
		request.setLastName("Angelo");
		request.setMobilePhone("119");

		HttpEntity<CreateCustomerRequest> body = new HttpEntity<CreateCustomerRequest>(request);
		ResponseEntity<Customer> data = rest.exchange(URL + "/customers", HttpMethod.POST, body, Customer.class);

		assertEquals(HttpStatus.OK, data.getStatusCode());

		Customer customer = data.getBody();
		assertNotNull(customer);
		assertNotNull(customer.getId());
		assertEquals(request.getMobilePhone(), customer.getMobilePhone());

	}
}
