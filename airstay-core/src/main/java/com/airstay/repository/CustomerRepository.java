package com.airstay.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airstay.domain.Customer;

/**
 * @author sarwo.wibowo
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findByMobilePhone(String mobilePhone);

}
