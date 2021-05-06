package com.travel.booking.domain.exception;

public class InvalidTrailException extends FunctionalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTrailException() {
		super("Invalid Trail Name");
	}
}
