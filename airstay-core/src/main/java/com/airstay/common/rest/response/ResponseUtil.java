package com.airstay.common.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.airstay.common.rest.response.error.Error;
import com.airstay.common.rest.response.error.InternalError;
import com.airstay.common.rest.response.error.RestErrorCode;
/**
 * @author sarwo.wibowo
 *
 */
public final class ResponseUtil {
	private ResponseUtil() {}
	
	public static ResponseEntity<RestResponse> notFoundError(String apiVersion, String module, RestErrorCode errorCode, String... args) {
		HttpStatus status = HttpStatus.NOT_FOUND;
        return toErrorResponse(apiVersion, module, errorCode, status, args);
	}

	public static ResponseEntity<RestResponse> badRequestError(String apiVersion, String module, RestErrorCode errorCode, String... args) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
        return toErrorResponse(apiVersion, module, errorCode, status, args);
	}
	
	public static ResponseEntity<RestResponse> unauthorizedError(String apiVersion, String module, RestErrorCode errorCode, String... args) {
		HttpStatus status = HttpStatus.UNAUTHORIZED;
        return toErrorResponse(apiVersion, module, errorCode, status, args);
	}
	
	public static ResponseEntity<RestResponse> serviceUnavailableError(String apiVersion, String module, RestErrorCode errorCode, String... args) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return toErrorResponse(apiVersion, module, errorCode, status, args);
    }
	
	public static ResponseEntity<RestResponse> okResponse(String apiVersion, Payload payload) {
        return new ResponseEntity<>(RestResponse.createResponse(payload, apiVersion), HttpStatus.OK);
    }

    public static ResponseEntity<RestResponse> noContent() {
        return new ResponseEntity<>(RestResponse.createEmptyResponse(), HttpStatus.NO_CONTENT);
    }

	
	private static ResponseEntity<RestResponse> toErrorResponse(String apiVersion, String module,
			RestErrorCode errorCode, HttpStatus status, String... args) {
		Error error = Error.builder().code(status.toString()).message(status.getReasonPhrase()).build();
        error.addInternalError(InternalError.builder().module(module).reason(errorCode.name()).message(String.format(errorCode.getMessage(), args)).build());
        return new ResponseEntity<>(RestResponse.createErrorResponse(error, apiVersion), status);
	}
}
