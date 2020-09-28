package com.airstay.hotel.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airstay.common.rest.response.ItemsPayload;
import com.airstay.common.rest.response.ResponseUtil;
import com.airstay.common.rest.response.RestResponse;
import com.airstay.hotel.rest.dto.BookingDto;
import com.airstay.hotel.rest.request.MakeBookingRequest;
import com.airstay.hotel.service.BookingService;

/**
 * @author sarwo.wibowo
 *
 */
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
	
	private String apiVersion = "v1";
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/{customerEmail}")
	public ResponseEntity<RestResponse> getBookingHistory(@PathVariable("customerEmail") String customerEmail) {
		List<BookingDto> bookings = bookingService.getByCustomerEmail(customerEmail);
		ItemsPayload<BookingDto> payloadDatas = new ItemsPayload<BookingDto>();
		payloadDatas.setItems(bookings);
		return ResponseUtil.okResponse(apiVersion, payloadDatas);
	
	}
	
	@PostMapping
	public ResponseEntity<RestResponse> makeBooking(@RequestBody MakeBookingRequest request) {
		BookingDto bookingDto = bookingService.makeBooking(request);
		return ResponseUtil.okResponse(apiVersion, bookingDto);
	}
	
}
