package com.cashdeskmodule.cashier;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cashdeskmodule.cashier.dto.CashierDto;

@Service
public class CashierMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(CashierMapper.class);

	private final AtomicLong atomicLong = new AtomicLong(1);

	public Cashier toCashier(CashierDto cashierDto) {

		LOGGER.info("toCashier() called");

		var cashier = new Cashier(atomicLong.getAndIncrement(), cashierDto.getCashierName(),
				cashierDto.getCashierAddress(), cashierDto.getCashierContact());

		return cashier;

	}

	public CashierDto toCashierDto(Cashier cashier) {

		LOGGER.info("toCashierDto() called");

		var cashierDto = new CashierDto(cashier.getCashierId(), cashier.getCashierName(), cashier.getCashierAddress(),
				cashier.getCashierContact());

		return cashierDto;

	}

}
