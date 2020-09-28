package com.airstay.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.airstay.hotel.domain.Address;
import com.airstay.hotel.domain.Hotel;
import com.airstay.hotel.mapper.HotelMapper;
import com.airstay.hotel.repository.HotelRepository;
import com.airstay.hotel.rest.dto.HotelDto;
import com.airstay.hotel.service.HotelService;
import com.google.common.base.Preconditions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sarwo.wibowo
 *
 */
@Slf4j
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public HotelDto create(String code, String name, Address address) {
		log.info("Creating hotel record");
		Preconditions.checkArgument(!StringUtils.isEmpty(code), "Hotel code is required");
		Preconditions.checkArgument(!StringUtils.isEmpty(name), "Hotel name is required");
		Preconditions.checkArgument(validAddress(address), "Hotel address is required");
		
		Hotel hotel = new Hotel();
		hotel.setAddress(address);
		hotel.setCode(code);
		hotel.setName(name);
		hotelRepository.save(hotel);
		log.info("Hotel record created {}", hotel);
		return HotelMapper.INSTANCE.entityToDto(hotel);
	}

	@Override
	public HotelDto getByCode(String code) {
		Hotel hotel = hotelRepository.findByCode(code);
		return HotelMapper.INSTANCE.entityToDto(hotel);
	}

	@Override
	public List<HotelDto> getAll() {
		List<Hotel> hotels = hotelRepository.findAll();
		return HotelMapper.INSTANCE.entitiesToDtos(hotels);
	}

	@Override
	public void dropAll() {
		hotelRepository.deleteAll();
	}
	
	private boolean validAddress(Address address) {
		if(address == null) {
			return false;
		}
		return !StringUtils.isEmpty(address.getStreet()) 
				&& !StringUtils.isEmpty(address.getCity())
				&& !StringUtils.isEmpty(address.getCountry());
	}

	
}
