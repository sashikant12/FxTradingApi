package com.Trading.FXTRADING.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
 
@Entity
public class FxTrading {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeNo; 
	private String name;
	private double transfer;
	private double transferValue;
	@OneToOne
	private TradingCurrencyPair tradingCurrencyPair;

	 // Constructor with parameters
    public FxTrading(String name, double transfer, TradingCurrencyPair tradingCurrencyPair) {
        this.name = name;
        this.transfer = transfer;
        this.tradingCurrencyPair = tradingCurrencyPair;
    }

    // Default constructor
    public FxTrading() {
 
    }

    // Getter for tradeNo
    public int getTradeNo() {
        return tradeNo;
    }

    // Setter for tradeNo
    public void setTradeNo(int tradeNo) {
        this.tradeNo = tradeNo;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for transfer
    public double getTransfer() {
        return transfer;
    }

    // Setter for transfer
    public void setTransfer(double transfer) {
        this.transfer = transfer;
    }

    // Getter for transferValue
    public double getTransferValue() {
        return transferValue;
    }

    // Setter for transferValue
    public void setTransferValue(double transferValue) {
        this.transferValue = transferValue;
    }

    // Getter for tradingCurrencyPair
    public TradingCurrencyPair getTradingCurrencyPair() {
        return tradingCurrencyPair;
    }

    // Setter for tradingCurrencyPair
    public void setTradingCurrencyPair(TradingCurrencyPair tradingCurrencyPair) {
        this.tradingCurrencyPair = tradingCurrencyPair;
    }
}
