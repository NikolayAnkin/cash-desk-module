package com.cashdeskmodule.cashier;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cashdeskmodule.cashier.dto.CashierDto;
import com.cashdeskmodule.cashier.exception.CashierNotFoundException;

@Service
public class CashierService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CashierService.class);

	private final CashierRepository cashierRepository;
	private final CashierMapper cashierMapper;

	public CashierService(CashierRepository cashierRepository, CashierMapper cashierMapper) {
		this.cashierRepository = cashierRepository;
		this.cashierMapper = cashierMapper;
	}

	public List<CashierDto> getAllCashiers() throws IOException {

		LOGGER.info("getAllCashiers() called");

		List<Cashier> cashiers = cashierRepository.findAll();
		if (cashiers == null || cashiers.isEmpty()) {
			throw new CashierNotFoundException("No cashiers found!");
		}

		return cashierRepository.findAll().stream().map(cashierMapper::toCashierDto).collect(Collectors.toList());
	}

	public CashierDto getCashierById(Long cashierId) {

		LOGGER.info("getCashierById() called");

		Cashier cashier = cashierRepository.findById(cashierId);

		if (cashier != null) {
			return cashierMapper.toCashierDto(cashier);
		} else {
			throw new CashierNotFoundException(String.format("No cashier found with the provided ID:: %s", cashierId));
		}
	}
}
