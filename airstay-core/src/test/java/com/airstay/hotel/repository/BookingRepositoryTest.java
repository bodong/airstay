package com.airstay.hotel.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.airstay.hotel.domain.Booking;

/**
 * @author sarwo.wibowo
 *
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class BookingRepositoryTest {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Test
	public void findByCode() {
		Booking booking = new Booking();
		booking.setHotelCode("TESTH");
		booking.setCustomerEmail("rod@johnson.com");
		bookingRepository.save(booking);
		
		List<Booking> bookingHistory = bookingRepository.findAllByCustomerEmail("rod@johnson.com");
		assertNotNull(bookingHistory);
		assertTrue(bookingHistory.contains(booking));
		
		List<Booking> noneBookingHistory = bookingRepository.findAllByCustomerEmail("kel@johnson.com");
		assertTrue(noneBookingHistory.isEmpty());
	}
	
	
}
