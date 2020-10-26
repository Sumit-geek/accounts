package com.anz.accounts.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends RuntimeException {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 5152071866122847669L;

	public TransactionNotFoundException(String msg) {
		super(msg);
	}

}
