package com.cashdeskmodule.cashier;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashdeskmodule.cashier.dto.CashierDto;

@RestController
@RequestMapping("/api/v1/cashier")
public class CashierController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CashierController.class);

	private final CashierService cashierService;

	public CashierController(CashierService cashierService) {
		this.cashierService = cashierService;
	}

	@GetMapping
	public ResponseEntity<List<CashierDto>> getAllCashiers() throws IOException {

		LOGGER.info("getAllCashiers() called");
		
		return ResponseEntity.ok(cashierService.getAllCashiers());
	}

	@GetMapping("/{cashierId}")
	public ResponseEntity<CashierDto> getCashierById(@PathVariable Long cashierId) {
		
		LOGGER.info("getCashierById() called");

		return ResponseEntity.ok(cashierService.getCashierById(cashierId));
	}
}
