package com.travel.booking.domain.exception;

public class InvalidDateException extends FunctionalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDateException(String message) {
		super(message);
	}
}
