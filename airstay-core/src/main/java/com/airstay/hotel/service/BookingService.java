package com.airstay.hotel.service;

import java.util.List;

import com.airstay.hotel.rest.dto.BookingDto;
import com.airstay.hotel.rest.request.MakeBookingRequest;

/**
 * @author sarwo.wibowo
 *
 */
public interface BookingService {
	BookingDto makeBooking(MakeBookingRequest request);

	List<BookingDto> getByCustomerEmail(String customerEmail);

	void dropAll();
}
