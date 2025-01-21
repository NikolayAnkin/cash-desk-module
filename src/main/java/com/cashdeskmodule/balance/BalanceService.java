package com.cashdeskmodule.balance;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cashdeskmodule.balance.dto.BalanceDto;
import com.cashdeskmodule.balance.exception.BalanceNotFoundException;

@Service
public class BalanceService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BalanceService.class);

	private final BalanceRepository balanceRepository;
	private final BalanceMapper balanceMapper;

	public BalanceService(BalanceRepository balanceRepository, BalanceMapper balanceMapper) {
		this.balanceRepository = balanceRepository;
		this.balanceMapper = balanceMapper;
	}

	public List<BalanceDto> getAllBalances(Long cashierId) {

		LOGGER.info("getAllBalances() called");

		return balanceRepository.getAllByCashierId(cashierId).stream().map(balanceMapper::toBalanceDto)
				.collect(Collectors.toList());
	}

	public BalanceDto getBalanceById(Long cashierId, Long balanceId) {

		LOGGER.info("getBalanceById() called");

		return balanceRepository.getAllByCashierId(cashierId).stream().filter(b -> b.getBalanceId().equals(balanceId))
				.map(balanceMapper::toBalanceDto).findFirst()
				.orElseThrow(() -> new BalanceNotFoundException(
						String.format("No balance found with the provided  Cashier ID: %s and Balance ID: %s",
								cashierId, balanceId)));
	}
}
