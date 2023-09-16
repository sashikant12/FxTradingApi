package com.Trading.FXTRADING.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Trading.FXTRADING.Entity.FxTrading;
import com.Trading.FXTRADING.Exception.CurrencyPairNotFoundException;
import com.Trading.FXTRADING.Services.FxTradingServices;

@RestController
public class FxTradingController  {
	@Autowired
	FxTradingServices fxTradingServices;

//checking connection
	@GetMapping("OlleOlle")
	public String letsDo() {
		return "Sab chal rha hai";
	}

//Get all trade 
	@GetMapping("GetAllTrade")
	public List<FxTrading> getAllTrade() {
		return fxTradingServices.getAllTrade();
	}

//Book trade 
	@PostMapping("TransferAmount")
	public String getTransferAmount(@RequestBody FxTrading trade) throws CurrencyPairNotFoundException {
		return fxTradingServices.getTransferAmount(trade);
	}

// Book trade by request value
	@PostMapping("ReciveAmount")
	public String getReciveAmount(@RequestBody FxTrading trade) throws CurrencyPairNotFoundException {
		return fxTradingServices.getReciveAmount(trade);
	 }
}