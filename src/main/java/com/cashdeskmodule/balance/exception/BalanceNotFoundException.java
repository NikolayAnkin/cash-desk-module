package com.cashdeskmodule.balance.exception;

public class BalanceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BalanceNotFoundException(String message) {
        super(message);
    }

}
