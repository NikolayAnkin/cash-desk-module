package com.cashdeskmodule.balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cashdeskmodule.transaction.Transaction;

public class Balance {

	private Long balanceId;
	private Long cashierId;
	private String cashierName;
	private String currency;
	private double balanceAmount;
	private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Balance() {

	}

	public Balance(Long balanceId, Long cashierId, String cashierName, String currency, double balanceAmount,
			Map<Integer, Integer> denominations) {
		
		this.balanceId = balanceId;
		this.cashierId = cashierId;
		this.cashierName = cashierName;
		this.currency = currency;
		this.balanceAmount = balanceAmount;
		this.denominations = denominations;
	}

	public Long getBalanceId() {
		return balanceId;
	}

	public void setBalanceId(Long balanceId) {
		this.balanceId = balanceId;
	}

	public Long getCashierId() {
		return cashierId;
	}

	public void setCashierId(Long cashierId) {
		this.cashierId = cashierId;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Map<Integer, Integer> getDenominations() {
		return denominations;
	}

	public void setDenominations(Map<Integer, Integer> denominations) {
		this.denominations = denominations;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Balance [balanceId=" + balanceId + ", cashierId=" + cashierId + ", cashierName=" + cashierName
				+ ", currency=" + currency + ", balanceAmount=" + balanceAmount + ", denominations=" + denominations
				+ ", operations=" + transactions + "]";
	}

}
