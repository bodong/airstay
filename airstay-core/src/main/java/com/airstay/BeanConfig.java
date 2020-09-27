package com.airstay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.airstay.service.CustomerService;
import com.airstay.service.impl.CustomerServiceImpl;

/**
 * @author sarwo.wibowo
 *
 */
@Configuration
public class BeanConfig {
	
	@Bean
	public CustomerService customerService() {
		return new CustomerServiceImpl();
	}
}
