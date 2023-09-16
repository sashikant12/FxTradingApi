package com.Trading.FXTRADING.Dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Trading.FXTRADING.Entity.FxTrading;

@Repository
public class FxTradingDao {
	@Autowired
	SessionFactory sessionFactory;

//	Get all from database
	public List<FxTrading> getAllTrade() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(FxTrading.class);
		return criteria.list();
	}

//	Saving send value database connection with valid currency pair
	public String getTransferAmount(FxTrading trade) {
		Session session = sessionFactory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return "Tranction is sucessfully made.Thank you visit again";
	}

//	Post need value database connection with valid currency pair
	public String getReciveAmount(FxTrading trade) {
		Session session = sessionFactory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return " Request Amount Tranction is sucessfully made.Thank you visit again";
	}
}
