package com.airstay.hotel.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.airstay.hotel.domain.Hotel;

/**
 * @author sarwo.wibowo
 *
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class HotelRepositoryTest {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Test
	public void findByCode() {
		Hotel hotel = new Hotel();
		hotel.setCode("TESTH");
		hotel.setName("Test Hotel");
		hotelRepository.save(hotel);
		
		Hotel findHotel = hotelRepository.findByCode("TESTH");
		assertNotNull(findHotel);
		
		Hotel none = hotelRepository.findByCode("NONE");
		assertNull(none);
	}
	
	
}
