package com.api.training.exceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Could not find the Collaborator";

	public NotFoundException(String exception) {
		super(exception);
	}

	public NotFoundException() {
		super(String.format(MESSAGE));
	}
}