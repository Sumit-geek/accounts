package com.anz.accounts.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

	/**
	 * Serialized ID
	 */
	private static final long serialVersionUID = 7237643991066674937L;

	public AccountNotFoundException(String msg) {
		super(msg);
	}

}
