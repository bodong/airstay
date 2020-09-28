package com.airstay.hotel.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airstay.common.rest.response.ItemsPayload;
import com.airstay.common.rest.response.ResponseUtil;
import com.airstay.common.rest.response.RestResponse;
import com.airstay.hotel.rest.dto.HotelDto;
import com.airstay.hotel.rest.dto.RoomDto;
import com.airstay.hotel.service.HotelService;
import com.airstay.hotel.service.RoomService;

/**
 * @author sarwo.wibowo
 *
 */
@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {
	
	private String apiVersion = "v1";
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping
	public ResponseEntity<RestResponse> getHotels() {
		List<HotelDto> hotels = hotelService.getAll();
		ItemsPayload<HotelDto> payloadDatas = new ItemsPayload<HotelDto>();
		payloadDatas.setItems(hotels);
		return ResponseUtil.okResponse(apiVersion, payloadDatas);
	
	}
	
	@GetMapping("/{hotelCode}/rooms")
	public ResponseEntity<RestResponse> getRoomsPerHotel(@PathVariable("hotelCode") String hotelCode) {
		List<RoomDto> rooms = roomService.getAllByHotelCode(hotelCode);
		ItemsPayload<RoomDto> payloadDatas = new ItemsPayload<RoomDto>();
		payloadDatas.setItems(rooms);
		return ResponseUtil.okResponse(apiVersion, payloadDatas);
	
	}
	
}
