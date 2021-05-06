package com.travel.booking.domain.exception;

public class UnknownBookingException extends FunctionalException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownBookingException(String message) {
	super(message);
	}
}
