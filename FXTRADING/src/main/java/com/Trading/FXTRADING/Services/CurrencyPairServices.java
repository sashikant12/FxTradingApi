package com.Trading.FXTRADING.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Trading.FXTRADING.Dao.CurrencyPairDao;
import com.Trading.FXTRADING.Entity.TradingCurrencyPair;

@Service
public class CurrencyPairServices {
	@Autowired
	CurrencyPairDao currenyPairDao;
//Get all currency pair
	public List<TradingCurrencyPair> getAllCurrencyPair() {
		return currenyPairDao.getAllCurrencyPair();
	}
}
