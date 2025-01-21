package com.cashdeskmodule.transaction.exception;

public class WithdrawNotPossibleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WithdrawNotPossibleException(String message) {
		super(message);
	}

}
