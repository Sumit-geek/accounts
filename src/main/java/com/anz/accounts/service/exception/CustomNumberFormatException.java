package com.anz.accounts.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomNumberFormatException extends RuntimeException {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 95042604268784564L;

	public CustomNumberFormatException(String msg) {
		super(msg);
	}
}
