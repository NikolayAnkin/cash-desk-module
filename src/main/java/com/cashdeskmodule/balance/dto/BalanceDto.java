package com.cashdeskmodule.balance.dto;

import java.util.Map;

public class BalanceDto {

	private Long balanceId;
	private Long cashierId;
	private String cashierName;
	private String currency;
	private double balanceAmount;
	private Map<Integer, Integer> denominations;

	public BalanceDto(Long balanceId, Long cashierId, String cashierName, String currency, double balanceAmount,
			Map<Integer, Integer> denominations) {
		
		this.setBalanceId(balanceId);
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

	@Override
	public String toString() {
		return "BalanceDto [cashierId=" + cashierId + ", cashierName=" + cashierName + ", currency=" + currency
				+ ", balanceAmount=" + balanceAmount + ", denominations=" + denominations + "]";
	}

}
