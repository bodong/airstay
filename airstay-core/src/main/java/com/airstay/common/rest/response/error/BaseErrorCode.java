package com.airstay.common.rest.response.error;

public enum BaseErrorCode implements RestErrorCode {
	BASE001("Internal server error"),
	BASE002("Bad request! %s!");
	
	private String message;
	
	private BaseErrorCode(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	
	

}
