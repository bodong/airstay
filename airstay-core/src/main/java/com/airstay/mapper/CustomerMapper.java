package com.airstay.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.airstay.domain.Customer;
import com.airstay.rest.controller.dto.CustomerDto;

@Mapper
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDto entityToDto(Customer entity);
	
	Customer dtoToEntity(CustomerDto dto);
	
	List<CustomerDto> entitiesToDtos(List<Customer> entities);
	
	List<Customer> dtosToEntities(List<CustomerDto> dtos);
}
