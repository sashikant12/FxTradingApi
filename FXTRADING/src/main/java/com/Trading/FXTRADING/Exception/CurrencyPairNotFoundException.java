package com.Trading.FXTRADING.Exception;

//custom exception
public class CurrencyPairNotFoundException extends Exception {
	public CurrencyPairNotFoundException(String message) {
		super(message);
	}
}
