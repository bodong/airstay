package com.airstay.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.airstay.hotel.domain.Room;
import com.airstay.hotel.mapper.RoomMapper;
import com.airstay.hotel.repository.RoomRepository;
import com.airstay.hotel.rest.dto.RoomDto;
import com.airstay.hotel.service.RoomService;
import com.google.common.base.Preconditions;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sarwo.wibowo
 *
 */
@Slf4j
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public RoomDto create(String code, String name, String hotelCode, boolean smooking, Double price) {
		
		Preconditions.checkArgument(!StringUtils.isEmpty(code), "Room code is required");
		Preconditions.checkArgument(!StringUtils.isEmpty(name), "Room name is required");
		Preconditions.checkArgument(!StringUtils.isEmpty(hotelCode), "Room hotel code is required");
		Preconditions.checkArgument(price != null, "Room price is required");
		
		log.info("Creating room data");
		
		Room room = toRoom(code, name, hotelCode, smooking, price);
		roomRepository.save(room);
		
		log.info("Room data is created {}", room);
		
		return RoomMapper.INSTANCE.entityToDto(room);
	}

	@Override
	public RoomDto getByCode(String code) {
		Room room = roomRepository.findByCode(code);
		return RoomMapper.INSTANCE.entityToDto(room);
	}

	@Override
	public List<RoomDto> getAllByHotelCode(String hotelCode) {
		List<Room> rooms = roomRepository.findAllByHotelCode(hotelCode);
		return RoomMapper.INSTANCE.entitiesToDtos(rooms);
	}

	@Override
	public void dropAll() {
		roomRepository.deleteAll();
	}
	private Room toRoom(String code, String name, String hotelCode, boolean smooking, Double price) {
		Room room = new Room();
		room.setCode(code);
		room.setHotelCode(hotelCode);
		room.setName(name);
		room.setPricePerNight(price);
		room.setSmooking(smooking);
		return room;
	}

}
