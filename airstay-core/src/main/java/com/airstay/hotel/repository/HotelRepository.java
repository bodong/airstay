package com.airstay.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airstay.hotel.domain.Hotel;

/**
 * @author sarwo.wibowo
 *
 */
public interface HotelRepository extends MongoRepository<Hotel, String> {

	Hotel findByCode(String code);

}
