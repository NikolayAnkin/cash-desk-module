package com.cashdeskmodule.transaction.validator;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cashdeskmodule.transaction.dto.TransactionDto;

@Component
public class TransactionValidator implements Validator {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionValidator.class);

	private static final Map<Integer, Integer> denominationsForDepositInBgn = Map.of(10, 10, 50, 10);
	private static final Map<Integer, Integer> denominationsForWithdrawInBgn = Map.of(10, 5, 50, 1);

	private static final Map<Integer, Integer> denominationsForDepositInEur = Map.of(20, 5, 50, 2);
	private static final Map<Integer, Integer> denominationsForWithdrawInEur = Map.of(50, 10);

	@Override
	public boolean supports(Class<?> clazz) {
		return TransactionDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		LOGGER.info("validate() called");

		TransactionDto transactionDto = (TransactionDto) target;

		if (transactionDto.getTransactionDenominations() == null
				|| transactionDto.getTransactionDenominations().isEmpty()) {
			errors.rejectValue("transactionDenominations", "Transaction Deniminations can't be empty!");
		}

		if ("BGN".equals(transactionDto.getTransactionCurrency())) {

			if ("DEPOSIT".equals(transactionDto.getTransactionType())) {

				if (transactionDto.getTransactionAmount() != 600) {
					errors.rejectValue("transactionAmount", "transactionAmount.required",
							"Deposit Amount in BGN is not correct!");
				}

				Map<Integer, Integer> denominations = transactionDto.getTransactionDenominations();
				if (!denominations.equals(denominationsForDepositInBgn)) {
					errors.rejectValue("transactionDenominations", "transactionDenominations.required",
							"Denominations for Deposit in BGN are not correct!");
				}

			}

			if ("WITHDRAW".equals(transactionDto.getTransactionType())) {

				if (transactionDto.getTransactionAmount() != 100) {
					errors.rejectValue("transactionAmount", "transactionAmount.required",
							"Withdraw Amount in BGN is not correct!");
				}

				Map<Integer, Integer> denominations = transactionDto.getTransactionDenominations();
				if (!denominations.equals(denominationsForWithdrawInBgn)) {
					errors.rejectValue("transactionDenominations", "transactionDenominations.required",
							"Denominations for Withdraw in BGN are not correct!");
				}

			}

		}

		if ("EUR".equals(transactionDto.getTransactionCurrency())) {

			if ("DEPOSIT".equals(transactionDto.getTransactionType())) {

				if (transactionDto.getTransactionAmount() != 200) {
					errors.rejectValue("transactionDenominations", "Deposit Amount in EUR is not correct!");
				}

				Map<Integer, Integer> denominations = transactionDto.getTransactionDenominations();
				if (!denominations.equals(denominationsForDepositInEur)) {
					errors.rejectValue("transactionDenominations", "Denominations for Deposit in EUR are not correct!");
				}

			}

			if ("WITHDRAW".equals(transactionDto.getTransactionType())
					&& transactionDto.getTransactionAmount() != 500) {

				if (transactionDto.getTransactionAmount() != 500) {
					errors.rejectValue("transactionDenominations", "Withdraw Amount in EUR is not correct!");
				}

				Map<Integer, Integer> denominations = transactionDto.getTransactionDenominations();
				if (!denominations.equals(denominationsForWithdrawInEur)) {
					errors.rejectValue("transactionDenominations",
							"Denominations for Withdraw in EUR are not correct!");
				}

			}
		}

	}

}
