package com.fdmgroup.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Runner {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Leader leader1 = new Leader(1,"Vladimir Putin"); 
		Leader leader2 = new Leader(2,"Joe Biden");
		Leader leader3 = new Leader(3,"Boris Johnson");

		Country country1 = new Country(1,"USA",leader2); // passing it in using constructor
		Country country2 = new Country(2,"UK",leader3);
		Country country3 = new Country(3,"Russia",leader1);
		
		entityTransaction.begin();
			entityManager.persist(country1); // persisting country- dont need to persist leader due to cascade
			entityManager.persist(country2);
			entityManager.persist(country3);
		entityTransaction.commit();
		
		entityManager = entityManagerFactory.createEntityManager();
		
		Leader leader = entityManager.find(Leader.class, 3);
		
		System.out.println(leader.getName()+": "+leader.getCountry().getName());
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
