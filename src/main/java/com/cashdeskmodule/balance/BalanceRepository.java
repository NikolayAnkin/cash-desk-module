package com.cashdeskmodule.balance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(BalanceRepository.class);

	Map<Long, Balance> balances = new HashMap<>();

	public List<Balance> getAllByCashierId(Long cashierId) {

		LOGGER.info("getAllByCashierId() called");

		return balances.values().stream().filter(balance -> balance.getCashierId().equals(cashierId))
				.collect(Collectors.toList());
	}

	public Balance findByCashierIdAndBalanceId(Long cashierId, Long balanceId) {

		LOGGER.info("findByCashierIdAndBalanceId() called");

		return balances.values().stream()
				.filter(balance -> balance.getCashierId().equals(cashierId) && balance.getBalanceId().equals(balanceId))
				.findAny().orElse(null);
	}

	public void save(Balance balance) {

		LOGGER.info("save() called");

		balances.put(balance.getBalanceId(), balance);
	}

}
