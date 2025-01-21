package com.cashdeskmodule.transaction.dto;

import java.time.LocalDate;
import java.util.Map;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TransactionDto {

	@NotEmpty(message = "Transaction Type can't be empty!")
	private String transactionType;

	@NotNull(message = "Transaction Amount can't be empty!")
	private Double transactionAmount;

	@NotEmpty(message = "Transaction Currency can't be empty!")
	private String transactionCurrency;

	private Map<Integer, Integer> transactionDenominations;

	private LocalDate transactionIssueDate;

	private Double balanceAmountAfterTransaction;

	private Map<Integer, Integer> balanceDenominationsAfterTransaction;

	public TransactionDto(String transactionType, Double transactionAmount, String transactionCurrency,
			Map<Integer, Integer> transactionDenominations, LocalDate transactionIssueDate,
			Double balanceAmountAfterTransaction, Map<Integer, Integer> balanceDenominationsAfterTransaction) {

		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionCurrency = transactionCurrency;
		this.transactionDenominations = transactionDenominations;
		this.transactionIssueDate = transactionIssueDate;
		this.balanceAmountAfterTransaction = balanceAmountAfterTransaction;
		this.balanceDenominationsAfterTransaction = balanceDenominationsAfterTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public Map<Integer, Integer> getTransactionDenominations() {
		return transactionDenominations;
	}

	public void setTransactionDenominations(Map<Integer, Integer> transactionDenominations) {
		this.transactionDenominations = transactionDenominations;
	}

	public LocalDate getTransactionIssueDate() {
		return transactionIssueDate;
	}

	public void setTransactionIssueDate(LocalDate transactionIssueDate) {
		this.transactionIssueDate = transactionIssueDate;
	}

	public Double getBalanceAmountAfterTransaction() {
		return balanceAmountAfterTransaction;
	}

	public void setBalanceAmountAfterTransaction(Double balanceAmountAfterTransaction) {
		this.balanceAmountAfterTransaction = balanceAmountAfterTransaction;
	}

	public Map<Integer, Integer> getBalanceDenominationsAfterTransaction() {
		return balanceDenominationsAfterTransaction;
	}

	public void setBalanceDenominationsAfterTransaction(Map<Integer, Integer> balanceDenominationsAfterTransaction) {
		this.balanceDenominationsAfterTransaction = balanceDenominationsAfterTransaction;
	}

}
