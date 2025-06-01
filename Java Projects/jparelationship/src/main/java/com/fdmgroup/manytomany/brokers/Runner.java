package com.fdmgroup.manytomany.brokers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Runner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Broker broker1 = new Broker(1,"John Smith");
		Broker broker2 = new Broker(2,"Jane Jones");
		Broker broker3 = new Broker(3,"Bob Smith");
		
		List<Broker> londonBrokers = new ArrayList<Broker>(Arrays.asList(broker1,broker2));
		List<Broker> newYorkBrokers = new ArrayList<Broker>(Arrays.asList(broker2,broker3));
		
		StockExchange stockExchange1 = new StockExchange(1,"London Stock Exchange",londonBrokers);
		StockExchange stockExchange2 = new StockExchange(2,"New York Stock Exchange",newYorkBrokers);
		
		entityTransaction.begin();
			entityManager.persist(stockExchange1);
			entityManager.persist(stockExchange2);
		entityTransaction.commit();
		
		
		
		
		entityManager.close();
		emf.close();
	}

}
