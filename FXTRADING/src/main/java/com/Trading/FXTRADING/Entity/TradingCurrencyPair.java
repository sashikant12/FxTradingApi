package com.Trading.FXTRADING.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TradingCurrencyPair {
	
	@Id
	private  int currencyNo;
	private String currencyPair;
	private double rate;
	  
	
	 // Constructor with a parameter to initialize currencyNo
    public TradingCurrencyPair(int currencyNo) {
        this.currencyNo = currencyNo;
    }

    // Default constructor with no parameters
    public TradingCurrencyPair() {
   
    }

    // Getter for currencyNo
    public int getCurrencyNo() {
        return currencyNo;
    }

    // Setter for currencyNo
    public void setCurrencyNo(int currencyNo) {
        this.currencyNo = currencyNo;
    }

    // Getter for currencyPair
    public String getCurrencyPair() {
        return currencyPair;
    }

    // Setter for currencyPair
    public void setCurrencyPair(String currencyPair) {
        this.currencyPair = currencyPair;
    }

    // Getter for rate
    public double getRate() {
        return rate;
    }

    // Setter for rate
    public void setRate(double rate) {
        this.rate = rate;
    }

	
}
