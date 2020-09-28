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

import com.airstay.hotel.domain.Address;
import com.airstay.hotel.domain.Hotel;
import com.airstay.hotel.repository.HotelRepository;
import com.airstay.hotel.rest.dto.HotelDto;
import com.airstay.hotel.service.impl.HotelServiceImpl;

/**
 * @author sarwo.wibowo
 *
 */
public class HotelServiceTest {

	@InjectMocks
	private HotelServiceImpl hotelService;
	
	@Mock
	private HotelRepository hotelRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getByCode() {
		String code = "TEST";
		when(hotelRepository.findByCode(code)).thenReturn(mockHotel(code));
		
		HotelDto hotelDto = hotelService.getByCode(code);
		assertNotNull(hotelDto);
		assertEquals(code, hotelDto.getCode());
		
		verify(hotelRepository, times(1)).findByCode(code);
		
		HotelDto none = hotelService.getByCode("none");
		assertNull(none);
		verify(hotelRepository, times(1)).findByCode(code);
		
		
	}
	
	@Test
	public void getAll() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(mockHotel("XYZ"));
		when(hotelRepository.findAll()).thenReturn(hotels);
		
		List<HotelDto> dtos = hotelService.getAll();
		assertTrue(dtos.size() == 1);
		
		verify(hotelRepository, times(1)).findAll();
		
	}
	
	@Test
	public void dropAll() {
		hotelService.dropAll();
		verify(hotelRepository, times(1)).deleteAll();
	}
	
	@Test
	public void create() {
		Hotel hotel = mockHotel("KLIA");
		when(hotelRepository.save(hotel)).thenReturn(hotel);
		
		HotelDto dto = hotelService.create(hotel.getCode(), hotel.getName(), hotel.getAddress());
		assertNotNull(dto);
		assertEquals(hotel.getCode(), dto.getCode());
		
		verify(hotelRepository, times(1)).save(any(Hotel.class));
	}
	

	private Hotel mockHotel(String code) {
		Hotel hotel = new Hotel();
		hotel.setCode(code);
		hotel.setName("Something");
		hotel.setId(UUID.randomUUID().toString());
		
		Address address = new Address();
		address.setCity("TEST CITY");
		address.setCountry("TEST COUNTRY");
		address.setStreet("TEST STREET");
		
		hotel.setAddress(address);
		return hotel;
	}
}
