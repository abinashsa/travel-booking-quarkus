package com.travel.booking.domain.exception;

/**
 * Class ExceptionMetier.
 */
public class FunctionalException extends Exception {

	/** Constant : serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instanciation de exception metier.
	 *
	 * @param msg message de l'exception
	 */
	public FunctionalException(String msg) {
		super(msg);
	}
}