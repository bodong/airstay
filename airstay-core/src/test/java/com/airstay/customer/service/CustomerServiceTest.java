package com.airstay.customer.service;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.airstay.customer.domain.Customer;
import com.airstay.customer.repository.CustomerRepository;
import com.airstay.customer.rest.dto.CustomerDto;
import com.airstay.customer.service.impl.CustomerServiceImpl;

/**
 * @author sarwo.wibowo
 *
 */
public class CustomerServiceTest {

	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAll() {
		when(customerRepository.findAll()).thenReturn(new ArrayList<Customer>());
		
		List<CustomerDto> getAll = customerService.getAll();
		assertNotNull(getAll);
		
		verify(customerRepository, times(1)).findAll();
		
	}
}
