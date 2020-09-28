package com.airstay.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airstay.hotel.domain.Room;

/**
 * @author sarwo.wibowo
 *
 */
public interface RoomRepository extends MongoRepository<Room, String> {
	
	List<Room> findAllByHotelCode(String hotelCode);
	
	Room findByCode(String code);

}
