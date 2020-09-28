package com.airstay.hotel.service;

import java.time.LocalDate;

/**
 * @author sarwo.wibowo
 *
 */
public interface CalculatorService {
	double calculateTotalPrice(double price, long totalNight);
	
	long calculateGapDays(LocalDate from, LocalDate to);
}
