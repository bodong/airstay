package com.airstay;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.airstay.tool.PreloadDataService;

/**
 * @author sarwo.wibowo
 *
 */
@SpringBootApplication
public class HotelExplorerApplication {
	
	@Autowired
	private PreloadDataService preloadDataService;
	
	@PostConstruct
	void init() {
		preloadDataService.createData();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(HotelExplorerApplication.class, args);
	}

}
