package com.airstay.rest.response.error;

import java.util.ArrayList;
import java.util.List;

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
public class Error {
	private String code;
	private String message;
	private List<InternalError> errors = new ArrayList<>();
	
	public void addInternalError(InternalError error) {
		if(this.errors == null) {
			this.errors = new ArrayList<>();
		}
		this.errors.add(error);
	}
}
