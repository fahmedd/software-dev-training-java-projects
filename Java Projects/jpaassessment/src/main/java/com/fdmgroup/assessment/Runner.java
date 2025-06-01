package com.fdmgroup.assessment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Runner {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("assessment");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		// 1. check that the Book table is generated in your database when you run this class
		// 2. Book will not be used in your assessment!
		// 3. No other tables in your database will be affected as this is a separate maven project
		
		Department department1= new Department("Academy");
		Department department2= new Department("Sales");
		
		Employee employee1 = new Employee("John Doe", "Trainer", department1);
		Employee employee2 = new Employee("Jane Doe", "Executive", department2);
		Employee employee3= new Employee("James Smith","Trainer", department1);
		
		
		
		entityTransaction.begin();
		
		entityManager.persist(department2);
		entityManager.persist(department1);
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		
		entityTransaction.commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}
}