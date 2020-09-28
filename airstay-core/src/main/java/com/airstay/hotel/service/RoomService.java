package com.airstay.hotel.service;

import java.util.List;

import com.airstay.hotel.rest.dto.RoomDto;

/**
 * @author sarwo.wibowo
 *
 */
public interface RoomService {
	RoomDto create(String code, String name, String hotelCode, boolean smooking, Double price);
	
	RoomDto getByCode(String code);

	List<RoomDto> getAllByHotelCode(String hotelCode);
	
	void dropAll();
	
}
