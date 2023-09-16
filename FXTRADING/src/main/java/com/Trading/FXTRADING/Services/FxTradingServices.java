package com.Trading.FXTRADING.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Trading.FXTRADING.Dao.CurrencyPairDao;
import com.Trading.FXTRADING.Dao.FxTradingDao;
import com.Trading.FXTRADING.Entity.FxTrading;
import com.Trading.FXTRADING.Entity.TradingCurrencyPair;
import com.Trading.FXTRADING.Exception.CurrencyPairNotFoundException;
import com.Trading.FXTRADING.Validations.Validation;

@Service
public class FxTradingServices {
	@Autowired
	FxTradingDao fxTradingDao;
	@Autowired
	CurrencyPairDao currenyPairDao;

//  Get all trade services
	public List<FxTrading> getAllTrade() {
		return fxTradingDao.getAllTrade();
	}

//	Post send value services with valid currency pair
	public String getTransferAmount(FxTrading trade) {
		try {
			if (Validation.isAmountValid(trade) && Validation.isValidName(trade)) {
				List<TradingCurrencyPair> trader = currenyPairDao.getCurrencyPairInfo();
				boolean currencyPairFound = Validation.SharedCurrencyPairStatus();

				for (TradingCurrencyPair trading : trader) {
					if (trading.getCurrencyNo() == trade.getTradingCurrencyPair().getCurrencyNo()) {
						trade.setTransferValue(trading.getRate() * trade.getTransfer());
						currencyPairFound = true;
						break;
					}
				}

				if (!currencyPairFound) {
					throw new CurrencyPairNotFoundException("No matching currency number found. Please try again.");
				}
			} else {
				return "Input is not valid, please try again.";
			}

			return fxTradingDao.getTransferAmount(trade);
		} catch (CurrencyPairNotFoundException e) {
			return "Currency pair not found: " + e.getMessage();
		}
	}

//	Post needed value services with valid currency pair
	public String getReciveAmount(FxTrading trade) {
		try {
			if (Validation.isAmountValid(trade) && Validation.isValidName(trade)) {
				// exchange values transfer to transferred value to know the actual amount to
				// get transfer
				trade.setTransferValue(trade.getTransfer());
				List<TradingCurrencyPair> trader = currenyPairDao.getCurrencyPairInfo();
				boolean currencyPairFound = Validation.SharedCurrencyPairStatus();

				for (TradingCurrencyPair trading : trader) {
					if (trading.getCurrencyNo() == trade.getTradingCurrencyPair().getCurrencyNo()) {
						trade.setTransfer(trade.getTransferValue() / trading.getRate());
						currencyPairFound = true;
						break;
					}
				}

				if (!currencyPairFound) {
					throw new CurrencyPairNotFoundException("No matching currency number found. Please try again.");
				}
			} else {
				return "Input is not valid, please try again.";
			}

			return fxTradingDao.getReciveAmount(trade);
		} catch (CurrencyPairNotFoundException e) {
			return "Currency pair not found: " + e.getMessage();
		}
	}

}