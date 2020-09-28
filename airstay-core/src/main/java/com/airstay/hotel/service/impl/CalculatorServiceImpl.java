package com.airstay.hotel.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.airstay.hotel.service.CalculatorService;

/**
 * @author sarwo.wibowo
 *
 */
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public double calculateTotalPrice(double price, long totalNight) {
		if(price == 0.0 || totalNight == 0) {
			return 0;
		}
		
		return price * totalNight;
	}

	@Override
	public long calculateGapDays(LocalDate from, LocalDate to) {
		if(from == null || to == null) {
			return 0;
		}
		long days = ChronoUnit.DAYS.between(from, to);
		return days;
	}

}
