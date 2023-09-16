package com.Trading.FXTRADING.Validations;

import com.Trading.FXTRADING.Entity.FxTrading;

public class Validation {
	// checking valid amount
	public static boolean isAmountValid(FxTrading trade) {
		if (trade.getTransfer() < 1) {
			return false;
		} else {
			return true;
		}
	}

	// checking valid pair
	public static boolean SharedCurrencyPairStatus() {
		boolean currencyPairFound = false;
		return currencyPairFound;
	}

	// checking valid Name
	public static boolean isValidName(FxTrading trade) {
		String name = trade.getName();
		if (!name.trim().equalsIgnoreCase("") && name.matches("^(?!\\.+$)[A-Za-z. ]+$")) {

			return true;
		} else {
			return false;
		}
	}
}
