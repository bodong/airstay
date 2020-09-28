package com.airstay.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airstay.customer.domain.Customer;

/**
 * @author sarwo.wibowo
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findByMobilePhone(String mobilePhone);
	
	Customer findByEmail(String email);

}
