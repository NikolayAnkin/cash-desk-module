package com.cashdeskmodule.balance;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cashdeskmodule.balance.dto.BalanceDto;
import com.cashdeskmodule.transaction.TransactionService;
import com.cashdeskmodule.transaction.dto.TransactionDto;

@RestController
@RequestMapping("/api/v1/cashier/{cashierId}/cash-balance")
public class BalanceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BalanceController.class);

	private final BalanceService balanceService;
	private final TransactionService transactionService;

	public BalanceController(BalanceService balanceService, TransactionService transactionService) {
		this.balanceService = balanceService;
		this.transactionService = transactionService;
	}

	@GetMapping
	public ResponseEntity<List<BalanceDto>> getAllBalances(@PathVariable Long cashierId) {

		LOGGER.info("getAllBalances() called");

		return ResponseEntity.ok(balanceService.getAllBalances(cashierId));
	}

	@GetMapping("/{balanceId}")
	public ResponseEntity<BalanceDto> getBalanceById(@PathVariable Long cashierId, @PathVariable Long balanceId) {

		LOGGER.info("getBalanceById() called");

		return ResponseEntity.ok(balanceService.getBalanceById(cashierId, balanceId));
	}

	@GetMapping("/movements/{balanceId}")
	public ResponseEntity<List<TransactionDto>> getBalanceMovements(
			@RequestParam Date dateFrom,
			@RequestParam Date dateTo, 
			@PathVariable Long cashierId,
			@PathVariable Long balanceId) {

		LOGGER.info("getBalanceMovements() called");

		LocalDate localDateFrom = LocalDate.ofInstant(dateFrom.toInstant(), ZoneId.systemDefault());
		LocalDate localDateTo = LocalDate.ofInstant(dateTo.toInstant(), ZoneId.systemDefault());
		
		return ResponseEntity.ok(transactionService.getTransactionsByBalanceId(balanceId, localDateFrom, localDateTo));
	}

}
