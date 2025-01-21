package com.cashdeskmodule.transaction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRepository.class);

	Map<Long, Transaction> transactions = new HashMap<>();
	File file = new File("src/main/resources/transactions.txt");

	public void save(Transaction transaction) {

		LOGGER.info("save() called");

		transactions.put(transaction.getTransactionId(), transaction);

		try {
			FileUtils.writeStringToFile(file,transaction.toString() + "\n", Charset.forName("UTF-8"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Transaction> getTransactionsByBalanceId(Long balanceId) {

		LOGGER.info("getTransactionsByBalanceId() called");

		return transactions.values().stream().filter(transaction -> transaction.getBalanceId().equals(balanceId))
				.collect(Collectors.toList());
	}
}
