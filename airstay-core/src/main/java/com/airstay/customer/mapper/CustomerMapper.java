package com.airstay.customer.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.airstay.customer.domain.Customer;
import com.airstay.customer.rest.dto.CustomerDto;

@Mapper
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	
	CustomerDto entityToDto(Customer entity);
	
	Customer dtoToEntity(CustomerDto dto);
	
	List<CustomerDto> entitiesToDtos(List<Customer> entities);
	
	List<Customer> dtosToEntities(List<CustomerDto> dtos);
}
