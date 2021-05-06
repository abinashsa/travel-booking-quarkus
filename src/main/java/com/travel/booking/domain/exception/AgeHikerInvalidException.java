package com.travel.booking.domain.exception;

public class AgeHikerInvalidException extends FunctionalException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AgeHikerInvalidException(String name) {
		super(name+" age is not in the range.");
	}

}
