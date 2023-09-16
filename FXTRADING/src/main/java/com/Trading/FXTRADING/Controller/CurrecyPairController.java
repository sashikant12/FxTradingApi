package com.Trading.FXTRADING.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Trading.FXTRADING.Entity.TradingCurrencyPair;
import com.Trading.FXTRADING.Services.CurrencyPairServices;

@RestController
public class CurrecyPairController {
	@Autowired
	CurrencyPairServices currencyPairServices;
	//Get all currency pair
	@GetMapping("getAllCurrencyPair")
	public List<TradingCurrencyPair> getAllCurrencyPair() {
		return  currencyPairServices.getAllCurrencyPair();
	}
}
