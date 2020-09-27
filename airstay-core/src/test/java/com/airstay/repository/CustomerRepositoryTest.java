package com.airstay.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.airstay.domain.Customer;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Test
	public void findByMobilePhone() {
		assertNotNull(customerRepository);
		
		Customer customer = new Customer();
		customer.setFirstName("Joko");
		customer.setLastName("Tingkir");
		customer.setMobilePhone("911");
		customer.setEmail("joko.tingkir@client.com");
		customerRepository.save(customer);
		
		Customer retrieveCustomer =  customerRepository.findByMobilePhone("911");
		assertNotNull(retrieveCustomer);
		assertEquals(customer, retrieveCustomer);
		
	}
	
	
}
