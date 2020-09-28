package com.airstay.hotel.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.airstay.hotel.domain.Room;
import com.airstay.hotel.rest.dto.RoomDto;

/**
 * @author sarwo.wibowo
 *
 */
@Mapper
public interface RoomMapper {
	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
	
	RoomDto entityToDto(Room entity);
	
	Room dtoToEntity(RoomDto dto);
	
	List<RoomDto> entitiesToDtos(List<Room> entities);
	
	List<Room> dtosToEntities(List<RoomDto> dtos);
}
