package com.Trading.FXTRADING.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Trading.FXTRADING.Entity.TradingCurrencyPair;

@Repository
public class CurrencyPairDao {
	@Autowired
	SessionFactory sessionFactory;

//getting all data from Trading currency pair
	public List<TradingCurrencyPair> getCurrencyPairInfo() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(TradingCurrencyPair.class);
		return criteria.list();
	}

	// get all currency pair
	public List<TradingCurrencyPair> getAllCurrencyPair() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(TradingCurrencyPair.class);
		return criteria.list();

	}
}
