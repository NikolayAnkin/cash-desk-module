package com.cashdeskmodule.cashier;

import java.util.ArrayList;
import java.util.List;

import com.cashdeskmodule.balance.Balance;

public class Cashier {

	private Long cashierId;
	private String cashierName;
	private String cashierAddress;
	private String cashierContact;
	private List<Balance> balances=new ArrayList<Balance>();
	
	public Cashier() {
		
	}

	public Cashier(Long cashierId, String cashierName, String cashierAddress, String cashierContact) {
		this.cashierId = cashierId;
		this.cashierName = cashierName;
		this.cashierAddress = cashierAddress;
		this.cashierContact=cashierContact;
		this.balances = new ArrayList<Balance>();
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

	public List<Balance> getBalances() {
		return balances;
	}

	public void setBalances(List<Balance> balances) {
		this.balances = balances;
	}

	@Override
	public String toString() {
		return "Cashier [cashierId=" + cashierId + ", cashierName=" + cashierName + ", cashierAddress=" + cashierAddress
				+ ", cashierContact=" + cashierContact + ", balances=" + balances + "]";
	}

}
