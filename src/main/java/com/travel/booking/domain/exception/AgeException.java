package com.travel.booking.domain.exception;

import java.util.List;

public class AgeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AgeHikerInvalidException> exceptions;

	public AgeException(List<AgeHikerInvalidException> exceptions) {
		super("Invalid Age for hikers");
		this.exceptions = exceptions;

	}

	public void setExceptions(List<AgeHikerInvalidException> exceptions) {
		this.exceptions = exceptions;
	}

	public List<AgeHikerInvalidException> getExceptions() {
		return exceptions;
	}
}
