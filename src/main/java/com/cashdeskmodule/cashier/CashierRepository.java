package com.cashdeskmodule.cashier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CashierRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(CashierRepository.class);

	Map<Long, Cashier> cashiers = new HashMap<Long, Cashier>();

	public List<Cashier> findAll() {
		
		LOGGER.info("findAll() called");
		
		return cashiers.values().stream().collect(Collectors.toList());
	}

	public Cashier findById(Long cashierId) {
		
		LOGGER.info("findById() called");
		
		return cashiers.values().stream().filter(cashier -> cashier.getCashierId().equals(cashierId)).findFirst()
				.orElse(null);
	}

	public void save(Cashier cashier) {

		LOGGER.info("save() called");
		
		cashiers.put(cashier.getCashierId(), cashier);
	}
}
