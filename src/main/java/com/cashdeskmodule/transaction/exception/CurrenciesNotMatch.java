package com.cashdeskmodule.transaction.exception;

public class CurrenciesNotMatch extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CurrenciesNotMatch(String message) {
		super(message);
	}

}
