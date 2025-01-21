package com.cashdeskmodule.transaction;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cashdeskmodule.transaction.dto.TransactionDto;

@Service
public class TransactionMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionMapper.class);

	private final AtomicLong atomicLong = new AtomicLong(1);

	public Transaction toTransaction(TransactionDto operationDto, Long balanceId) {

		LOGGER.info("toTransaction() called");

		Transaction transaction = new Transaction();
		transaction.setTransactionId(atomicLong.getAndIncrement());
		transaction.setBalanceId(balanceId);
		transaction.setTransactionType(operationDto.getTransactionType());
		transaction.setTransactionAmount(operationDto.getTransactionAmount());
		transaction.setTransactionCurrency(operationDto.getTransactionCurrency());
		transaction.setTransactionDenominations(operationDto.getTransactionDenominations());
		transaction.setTransactionIssueDate(LocalDate.now());

		return transaction;
	}

	public TransactionDto toTransactionDto(Transaction transaction) {

		LOGGER.info("toTransactionDto() called");

		TransactionDto transactionDto = new TransactionDto(
				transaction.getTransactionType(), transaction.getTransactionAmount(),
				transaction.getTransactionCurrency(), transaction.getTransactionDenominations(),
				transaction.getTransactionIssueDate(), transaction.getBalanceAmountAfterTransaction(),
				transaction.getBalanceDenominationsAdterTransaction());

		return transactionDto;
	}
}
