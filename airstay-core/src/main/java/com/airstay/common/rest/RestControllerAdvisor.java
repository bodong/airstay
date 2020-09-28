package com.airstay.common.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.airstay.common.rest.response.ResponseUtil;
import com.airstay.common.rest.response.RestResponse;
import com.airstay.common.rest.response.error.BaseErrorCode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sarwo.wibowo
 *
 */
@RestControllerAdvice
@Slf4j
public class RestControllerAdvisor extends ResponseEntityExceptionHandler {
	private final String apiVersion = "v1";
	private final String module = "base";
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<RestResponse> unhandledError(Exception ex) {
		log.error("unhandled error ", ex);
		return ResponseUtil.serviceUnavailableError(apiVersion, module, BaseErrorCode.BASE001);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
	@ResponseBody
	public ResponseEntity<RestResponse> badRequest(Exception ex) {
		log.error("Bad request ", ex);
		return ResponseUtil.badRequestError(apiVersion, module, BaseErrorCode.BASE002, ex.getMessage());
	}
}
