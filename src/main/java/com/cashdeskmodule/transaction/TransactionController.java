package com.cashdeskmodule.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashdeskmodule.balance.BalanceService;
import com.cashdeskmodule.transaction.dto.TransactionDto;
import com.cashdeskmodule.transaction.validator.TransactionValidator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cashier/{cashierId}/cash-balance/{balanceId}/cash-operation")
public class TransactionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

	private final TransactionService operationService;
	private final TransactionValidator transactionValidator;

	public TransactionController(TransactionService operationService, BalanceService balanceService,
			TransactionValidator transactionValidator) {

		this.operationService = operationService;
		this.transactionValidator = transactionValidator;
	}

	@PostMapping
	public ResponseEntity<?> performOperation(@PathVariable Long cashierId, @PathVariable Long balanceId,
			@RequestBody @Valid TransactionDto transactionDto) {

		LOGGER.info("performOperation() called");

		Errors errors = new BeanPropertyBindingResult(transactionDto, "transactionDto");
		transactionValidator.validate(transactionDto, errors);

		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}

		operationService.performOperation(cashierId, balanceId, transactionDto);

		return new ResponseEntity<String>("Transaction performed successfully!", HttpStatus.OK);
	}

}
