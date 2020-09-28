package com.airstay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.airstay.customer.service.CustomerService;
import com.airstay.customer.service.impl.CustomerServiceImpl;
import com.airstay.hotel.service.BookingService;
import com.airstay.hotel.service.CalculatorService;
import com.airstay.hotel.service.HotelService;
import com.airstay.hotel.service.RoomService;
import com.airstay.hotel.service.impl.BookingServiceImpl;
import com.airstay.hotel.service.impl.CalculatorServiceImpl;
import com.airstay.hotel.service.impl.HotelServiceImpl;
import com.airstay.hotel.service.impl.RoomServiceImpl;
import com.airstay.tool.PreloadDataService;
import com.airstay.tool.service.PreloadDataServiceImpl;

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

	@Bean
	public HotelService hotelService() {
		return new HotelServiceImpl();
	}

	@Bean
	public RoomService roomService() {
		return new RoomServiceImpl();
	}

	@Bean
	public PreloadDataService preloadDataService() {
		return new PreloadDataServiceImpl();
	}

	@Bean
	public BookingService bookingService() {
		return new BookingServiceImpl();
	}

	@Bean
	public CalculatorService calculatorService() {
		return new CalculatorServiceImpl();
	}

}
