package com.cashdeskmodule.handler;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cashdeskmodule.balance.exception.BalanceNotFoundException;
import com.cashdeskmodule.cashier.exception.CashierNotFoundException;
import com.cashdeskmodule.transaction.exception.CurrenciesNotMatch;
import com.cashdeskmodule.transaction.exception.NoMovementsAvailableException;
import com.cashdeskmodule.transaction.exception.WithdrawNotPossibleException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CashierNotFoundException.class)
	public ResponseEntity<String> handle(CashierNotFoundException exception) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler(BalanceNotFoundException.class)
	public ResponseEntity<String> handle(BalanceNotFoundException exception) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler(CurrenciesNotMatch.class)
	public ResponseEntity<String> handle(CurrenciesNotMatch exception) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler(NoMovementsAvailableException.class)
	public ResponseEntity<String> handle(NoMovementsAvailableException exception) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler(WithdrawNotPossibleException.class)
	public ResponseEntity<String> handle(WithdrawNotPossibleException exception) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exception) {

		var errors = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {

			var fieldName = ((FieldError) error).getField();
			var errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);

		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
	}

}
