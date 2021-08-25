package com.codeWizard.tfa.entities;

import javax.persistence.Embeddable;


/************************************************************************************
 *          @author          Swapnava Halder
 *          Description      It is a embedded class for Wallet default constructor, 
 *          				 parameterized constructor along with getters and setters.
 *         Version             1.0
 *         Created Date    27-July-2021
 ************************************************************************************/

@Embeddable
public class Wallet {
	private String balance;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public Wallet() {
		super();
	}
	
	public Wallet(String balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Wallet [balance=" + balance + "]";
	}
}
