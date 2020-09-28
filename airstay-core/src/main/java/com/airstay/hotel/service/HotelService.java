package com.airstay.hotel.service;

import java.util.List;

import com.airstay.hotel.domain.Address;
import com.airstay.hotel.rest.dto.HotelDto;

/**
 * @author sarwo.wibowo
 *
 */
public interface HotelService {
	HotelDto create(String code, String name, Address address);
	
	HotelDto getByCode(String code);

	List<HotelDto> getAll();
	
	void dropAll();
	
}
