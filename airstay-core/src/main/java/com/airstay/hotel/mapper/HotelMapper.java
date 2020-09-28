package com.airstay.hotel.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.airstay.hotel.domain.Hotel;
import com.airstay.hotel.rest.dto.HotelDto;

/**
 * @author sarwo.wibowo
 *
 */
@Mapper
public interface HotelMapper {
	HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);
	
	HotelDto entityToDto(Hotel entity);
	
	Hotel dtoToEntity(HotelDto dto);
	
	List<HotelDto> entitiesToDtos(List<Hotel> entities);
	
	List<Hotel> dtosToEntities(List<HotelDto> dtos);
}
