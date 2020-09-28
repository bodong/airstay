package com.airstay.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airstay.hotel.domain.Booking;

/**
 * @author sarwo.wibowo
 *
 */
public interface BookingRepository extends MongoRepository<Booking, String> {
	List<Booking> findAllByCustomerEmail(String customerEmail);
}
