package com.cashdeskmodule.cashier.dto;

public class CashierDto {

	private Long cashierId;
	private String cashierName;
	private String cashierAddress;
	private String cashierContact;

	public CashierDto(Long cashierId, String cashierName, String cashierAddress, String cashierContact) {
		this.cashierId = cashierId;
		this.cashierName = cashierName;
		this.cashierAddress = cashierAddress;
		this.cashierContact = cashierContact;
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

	public String getCashierAddress() {
		return cashierAddress;
	}

	public void setCashierAddress(String cashierAddress) {
		this.cashierAddress = cashierAddress;
	}

	public String getCashierContact() {
		return cashierContact;
	}

	public void setCashierContact(String cashierContact) {
		this.cashierContact = cashierContact;
	}

	@Override
	public String toString() {
		return "CashierDto [cashierName=" + cashierName + ", cashierAddress=" + cashierAddress + ", cashierContact="
				+ cashierContact + "]";
	}
}
