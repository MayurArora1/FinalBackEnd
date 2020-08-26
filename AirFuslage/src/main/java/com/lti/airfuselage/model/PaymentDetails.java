package com.lti.airfuselage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("payment")
@Scope(scopeName="prototype")
@Entity
@Table(name="payment")
public class PaymentDetails {
	
	@Id
	@Column(name="card_number")
	private long cardNumber;
	
	@Column(name="expiry_date")
	private String expiryDate;
	
	@Column(name="cvv")
	private int cvv;
	
	@Column(name="account_balance")
	private long accountBalance;

	public PaymentDetails() {}

	public PaymentDetails(long cardNumber, String expiryDate, int cvv, long accountBalance) {
		super();
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.accountBalance = accountBalance;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
}
