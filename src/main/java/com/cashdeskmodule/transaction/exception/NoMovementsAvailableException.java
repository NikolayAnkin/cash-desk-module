package com.cashdeskmodule.transaction.exception;

public class NoMovementsAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoMovementsAvailableException(String message) {
		super(message);
	}

}
