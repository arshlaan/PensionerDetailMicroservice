package com.cognizant.PensionerDetailMicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DetailsNotFoundException extends RuntimeException {
	public DetailsNotFoundException(String message) {
		super(message);
	}
}
