package com.airstay.common.rest.response.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

/**
 * @author sarwo.wibowo
 *
 */
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InternalError {
	private String module;
	private String reason;
	private String message;
}
