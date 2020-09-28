package com.airstay.hotel.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.airstay.hotel.domain.Booking;
import com.airstay.hotel.rest.dto.BookingDto;

/**
 * @author sarwo.wibowo
 *
 */
@Mapper
public interface BookingMapper {
	BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
	
	BookingDto entityToDto(Booking entity);
	
	Booking dtoToEntity(BookingDto dto);
	
	List<BookingDto> entitiesToDtos(List<Booking> entities);
	
	List<Booking> dtosToEntities(List<BookingDto> dtos);
}
