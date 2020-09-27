package com.airstay.rest.response;

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
public class ResponseWithPayload extends RestResponse {
	private Payload data;
}
