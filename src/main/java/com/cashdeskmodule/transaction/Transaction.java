package com.cashdeskmodule.transaction;

import java.time.LocalDate;
import java.util.Map;

public class Transaction {

	private Long transactionId;
	private Long balanceId;
	private String transactionType;
	private Double transactionAmount;
	private String transactionCurrency;
	private Map<Integer, Integer> transactionDenominations;
	private LocalDate transactionIssueDate;
	private Double balanceAmountAfterTransaction;
	private Map<Integer, Integer> balanceDenominationsAdterTransaction;

	public Transaction() {

	}

	public Transaction(Long transactionId, Long balanceId, String transactionType, double transactionAmount,
			Map<Integer, Integer> transactionDenominations, LocalDate transactionIssueDate,
			Double balanceAmountAfterTransaction, Map<Integer, Integer> balanceDenominationsAdterTransaction) {

		this.transactionId = transactionId;
		this.balanceId = balanceId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDenominations = transactionDenominations;
		this.transactionIssueDate = transactionIssueDate;
		this.balanceAmountAfterTransaction = balanceAmountAfterTransaction;
		this.balanceDenominationsAdterTransaction = balanceDenominationsAdterTransaction;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
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

	public Map<Integer, Integer> getBalanceDenominationsAdterTransaction() {
		return balanceDenominationsAdterTransaction;
	}

	public void setBalanceDenominationsAdterTransaction(Map<Integer, Integer> balanceDenominationsAdterTransaction) {
		this.balanceDenominationsAdterTransaction = balanceDenominationsAdterTransaction;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", balanceId=" + balanceId + ", transactionType="
				+ transactionType + ", transactionAmount=" + transactionAmount + ", transactionCurrency="
				+ transactionCurrency + ", transactionDenominations=" + transactionDenominations
				+ ", transactionIssueDate=" + transactionIssueDate + ", balanceAmountAfterTransaction="
				+ balanceAmountAfterTransaction + ", balanceDenominationsAdterTransaction="
				+ balanceDenominationsAdterTransaction + "]";
	}

}
