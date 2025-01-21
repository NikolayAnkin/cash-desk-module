package com.cashdeskmodule.balance;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cashdeskmodule.balance.dto.BalanceDto;

@Service
public class BalanceMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(BalanceMapper.class);

	private final AtomicLong atomicLong = new AtomicLong(1);

	public BalanceDto toBalanceDto(Balance balance) {

		 LOGGER.info("toBalanceDto() called");

		BalanceDto balanceDto = new BalanceDto(balance.getBalanceId(), balance.getCashierId(), balance.getCashierName(),
				balance.getCurrency(), balance.getBalanceAmount(), balance.getDenominations());

		return balanceDto;
	}

	public Balance toBalance(BalanceDto balanceDto) {

		LOGGER.info("toBalance() called");

		Balance balance = new Balance(atomicLong.getAndIncrement(), balanceDto.getCashierId(),
				balanceDto.getCashierName(), balanceDto.getCurrency(), balanceDto.getBalanceAmount(),
				balanceDto.getDenominations());

		return balance;
	}

}
