package com.airstay.rest.response;

import com.airstay.rest.response.error.Error;

import lombok.Getter;

/**
 * @author sarwo.wibowo
 *
 */
public abstract class RestResponse {
	
	@Getter
	protected String apiVersion;

	public static ResponseEmpty createEmptyResponse() {
		ResponseEmpty responseEmpty = new ResponseEmpty();
		return responseEmpty;
	}
	
	public static ResponseWithError createErrorResponse(Error error, String apiVersion) {
		ResponseWithError responseWithError = ResponseWithError.builder().error(error).build();
		responseWithError.apiVersion = apiVersion;
		return responseWithError;
	}

	public static ResponseWithPayload createResponse(Payload payload, String apiVersion) {
		ResponseWithPayload responseWithPayload = ResponseWithPayload.builder().data(payload).build();
		responseWithPayload.apiVersion = apiVersion;
		return responseWithPayload;
	}

}
