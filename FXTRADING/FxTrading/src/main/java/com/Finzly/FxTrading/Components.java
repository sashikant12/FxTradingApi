package com.Finzly.FxTrading;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.FxTrading.Model.Trade;

@RestController
@RequestMapping("Trade")
public class Components {

	Trade trade;

	List<Trade> trades = new ArrayList<>();

	@GetMapping("Book")
	public String getBook() {
		if (!isValidTrade(trade)) {
			return "Invalid input please try again";
		} else {

			trades.add(trade);
			trade.setTradeNo(size());

			return "Trade for " + trade.getCurrencyPair().toUpperCase() + " has been booked with rate "
					+ trade.getRate() + ", The amount of Rs " + trade.getInrValue()
					+ " will be transferred in 2 working days to " + trade.getName().toUpperCase();
		}
	}

	@PostMapping
	public String PostBook(@RequestBody Trade trade) {
		this.trade = trade;

		trade.setInrValue(totalAmount());

		if (!isValidTrade(trade)) {
			return "Invalid input try again..";
		} else {
			return "Go to  book to book your trade";
		}
	}

	@GetMapping("Print")
	public List<Trade> printTrades() {
		return trades;
	}

	@GetMapping("Rate")
	public String rate() {
		if (!isValidTrade(trade)) {
			return "Invalid input try again..";
		} else {
			return "You are transferring " + trade.getCurrencyPair().substring(3, 6).toUpperCase() + " "
					+ trade.getInrValue() + " to " + trade.getName().toUpperCase() + " ( Assuming that rate was "
					+ trade.getRate() + ")";
		}
	}

	@GetMapping("Exit")
	public String exitProgram() {
		trades.clear();
		return "Bye - have a good day";
	}

	private boolean isValidTrade(Trade trade) {
		if (trade != null && trade.getTransfer() > 1 && !trade.getName().trim().isEmpty()
				&& trade.getCurrencyPair().equalsIgnoreCase("USDINR")) {
			return true;
		} else {
			return false;
		}
	}

	private double totalAmount() {
		return trade.getTransfer() * trade.getRate();
	}

	private int size() {
		return trades.size();
	}

}