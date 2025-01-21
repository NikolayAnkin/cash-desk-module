package com.cashdeskmodule.transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cashdeskmodule.balance.Balance;
import com.cashdeskmodule.balance.BalanceRepository;
import com.cashdeskmodule.balance.exception.BalanceNotFoundException;
import com.cashdeskmodule.transaction.dto.TransactionDto;
import com.cashdeskmodule.transaction.exception.CurrenciesNotMatch;
import com.cashdeskmodule.transaction.exception.NoMovementsAvailableException;
import com.cashdeskmodule.transaction.exception.WithdrawNotPossibleException;

@Service
public class TransactionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

	private final TransactionRepository operationRepository;
	private final BalanceRepository balanceRepository;
	private final TransactionMapper transactionMapper;

	public TransactionService(TransactionRepository operationRepository, BalanceRepository balanceRepository,
			TransactionMapper transactionMapper) {

		this.operationRepository = operationRepository;
		this.balanceRepository = balanceRepository;
		this.transactionMapper = transactionMapper;
	}

	public void performOperation(Long cashierId, Long balanceId, TransactionDto transactionDto) {

		LOGGER.info("performOperation() called");

		Balance balance = balanceRepository.getAllByCashierId(cashierId).stream()
				.filter(b -> b.getBalanceId().equals(balanceId)).findFirst().orElse(null);

		if (balance == null) {
			throw new BalanceNotFoundException("Balance does not exists!");
		}

		if (!balance.getCurrency().equals(transactionDto.getTransactionCurrency())) {
			throw new CurrenciesNotMatch("Currencies of transaction and balance does not match!");
		}

		Transaction transaction = transactionMapper.toTransaction(transactionDto, balanceId);

		if (Objects.equals(transactionDto.getTransactionType(), "DEPOSIT")) {
			updateBalanceOnDeposit(balance, transaction);
		}

		if (Objects.equals(transactionDto.getTransactionType(), "WITHDRAW")) {
			updateBalanceOnWithdraw(balance, transaction);
		}

	}

	private void updateBalanceOnDeposit(Balance balance, Transaction transaction) {

		LOGGER.info("updateBalanceOnDeposit() called");

		double updatedBalanceAmount = balance.getBalanceAmount() + transaction.getTransactionAmount();
		balance.setBalanceAmount(updatedBalanceAmount);

		transaction.setBalanceAmountAfterTransaction(updatedBalanceAmount);

		Map<Integer, Integer> balanceDenominations = balance.getDenominations();

		Map<Integer, Integer> transactionDenominations = transaction.getTransactionDenominations();
		transactionDenominations.forEach((key, value) -> balanceDenominations.merge(key, value, Integer::sum));

		transaction.setBalanceDenominationsAdterTransaction(balance.getDenominations());

		balance.getTransactions().add(transaction);

		balanceRepository.save(balance);

		operationRepository.save(transaction);
	}

	private void updateBalanceOnWithdraw(Balance balance, Transaction transaction) {

		LOGGER.info("updateBalanceOnWithdraw() called");

		double updatedBalanceAmount = balance.getBalanceAmount() - transaction.getTransactionAmount();
		balance.setBalanceAmount(updatedBalanceAmount);
		transaction.setBalanceAmountAfterTransaction(updatedBalanceAmount);

		Map<Integer, Integer> balanceDenominations = balance.getDenominations();

		Map<Integer, Integer> transactionDenominations = transaction.getTransactionDenominations();
		transactionDenominations.forEach((key, value) -> {

			int balanceValue = balanceDenominations.get(key);
			if (balanceValue >= value) {
				balanceDenominations.merge(key, value, (a, b) -> a - b);
			} else {
				throw new WithdrawNotPossibleException("Withdraw is not possibe with the provided denominations!");
			}

		});

		transaction.setBalanceDenominationsAdterTransaction(balance.getDenominations());
		balance.getTransactions().add(transaction);

		balanceRepository.save(balance);

		operationRepository.save(transaction);
	}

	public List<TransactionDto> getTransactionsByBalanceId(Long balanceId, LocalDate dateFrom, LocalDate dateTo) {

		List<Transaction> transactions = operationRepository.getTransactionsByBalanceId(balanceId);
		if (transactions == null || transactions.isEmpty()) {
			throw new NoMovementsAvailableException("No balance movements available!");
		}

		if (dateFrom != null && dateTo != null) {

			return operationRepository.getTransactionsByBalanceId(balanceId).stream()
					.filter(transaction -> transaction.getTransactionIssueDate().isAfter(dateFrom)
							&& transaction.getTransactionIssueDate().isBefore(dateTo))
					.map(transactionMapper::toTransactionDto).collect(Collectors.toList());
		}

		return operationRepository.getTransactionsByBalanceId(balanceId).stream()
				.map(transactionMapper::toTransactionDto).collect(Collectors.toList());
	}

}
