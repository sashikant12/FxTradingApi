package com.Finzly.FxTrading.Model;

import org.springframework.stereotype.Service;

@Service
public class Trade {
	// Properties
	private int tradeNo = 0;
	private String name;
	private String currencyPair;
	private static double rate = 90;
	private double transfer;
	private double inrValue = 0;

	// Constructor
	public Trade(String name, double transfer, String currencyPair) {
		this.name = name.toUpperCase();
		this.transfer = transfer;
		this.currencyPair = currencyPair.toUpperCase();
	}
	//	Constructor
	public Trade() {

	}

	// Setter for trade number
	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}

	// Getter for customer name
	public String getName() {
		return name.toUpperCase();
	}

	// Getter for transfer amount
	public double getTransfer() {
		return transfer;
	}

	// Getter for currency pair
	public String getCurrencyPair() {
		return currencyPair.toUpperCase();
	}

	// Getter for rate
	public double getRate() {
		return rate;
	}

	// Getter for trade number
	public int getTradeNo() {
		return tradeNo;
	}
	// Getter for INR Value
	public double getInrValue() {
		return inrValue;
	}
	// Setter for INR Value
	public void setInrValue(double inrValue) {
		this.inrValue = inrValue;
	}
}
