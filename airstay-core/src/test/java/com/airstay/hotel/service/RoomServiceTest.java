package com.airstay.hotel.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.airstay.hotel.domain.Room;
import com.airstay.hotel.repository.RoomRepository;
import com.airstay.hotel.rest.dto.RoomDto;
import com.airstay.hotel.service.impl.RoomServiceImpl;

/**
 * @author sarwo.wibowo
 *
 */
public class RoomServiceTest {

	@InjectMocks
	private RoomServiceImpl roomService;
	
	@Mock
	private RoomRepository roomRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getByCode() {
		String code = "TEST";
		when(roomRepository.findByCode(code)).thenReturn(mockRoom(code));
		
		RoomDto roomDto = roomService.getByCode(code);
		assertNotNull(roomDto);
		assertEquals(code, roomDto.getCode());
		
		verify(roomRepository, times(1)).findByCode(code);
		
		RoomDto none = roomService.getByCode("none");
		assertNull(none);
		verify(roomRepository, times(1)).findByCode(code);
		
		
	}
	
	@Test
	public void getAll() {
		List<Room> records = new ArrayList<Room>();
		records.add(mockRoom("XYZ"));
		when(roomRepository.findAllByHotelCode("HXYZ")).thenReturn(records);
		
		List<RoomDto> dtos = roomService.getAllByHotelCode("HXYZ");
		assertTrue(dtos.size() == 1);
		
		verify(roomRepository, times(1)).findAllByHotelCode("HXYZ");
		
	}
	
	@Test
	public void dropAll() {
		roomService.dropAll();
		verify(roomRepository, times(1)).deleteAll();
	}
	
	@Test
	public void create() {
		Room room = mockRoom("KLIA");
		when(roomRepository.save(room)).thenReturn(room);
		
		RoomDto dto = roomService.create(room.getCode(), room.getName(), room.getHotelCode(), room.isSmooking(), room.getPricePerNight());
		assertNotNull(dto);
		assertEquals(room.getCode(), dto.getCode());
		
		verify(roomRepository, times(1)).save(any(Room.class));
	}
	

	private Room mockRoom(String code) {
		Room room = new Room();
		room.setCode(code);
		room.setHotelCode("H" + code);
		room.setName("ANY ROOM");
		room.setId(UUID.randomUUID().toString());
		room.setPricePerNight(200.0);
		return room;
	}
}
