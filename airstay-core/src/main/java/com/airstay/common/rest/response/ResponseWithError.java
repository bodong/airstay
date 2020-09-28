package com.airstay.common.rest.response;

import com.airstay.common.rest.response.error.Error;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sarwo.wibowo
 *
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWithError extends RestResponse {
	private Error error;
}
