package com.airstay.hotel.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.airstay.hotel.domain.Room;

/**
 * @author sarwo.wibowo
 *
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class RoomRepositoryTest {

	@Autowired
	private RoomRepository roomRepository;
	
	@Test
	public void findByCode() {
		Room room = new Room();
		room.setCode("ROOM1");
		room.setName("Test Room");
		roomRepository.save(room);
		
		Room findRoom = roomRepository.findByCode("ROOM1");
		assertNotNull(findRoom);
		
		Room notExistRoom = roomRepository.findByCode("XX001");
		assertNull(notExistRoom);
		
	}
	
	
}
