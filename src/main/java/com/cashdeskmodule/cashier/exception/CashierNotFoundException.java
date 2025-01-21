package com.cashdeskmodule.cashier.exception;

public class CashierNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CashierNotFoundException(String message) {
		super(message);
	}

}
