package com.fdmgroup.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Runner {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Customer customer1 = new Customer();
		customer1.setCustomerId(1);
		customer1.setCustomerName("A");

		Customer customer2 = new Customer();
		customer2.setCustomerId(2);
		customer2.setCustomerName("B");

		Address address1 = new Address();
		address1.setAddressId(1);
		address1.setAddress("A");
		address1.setCustomer(customer1);

		Address address2 = new Address();
		address2.setAddressId(2);
		address2.setAddress("B");
		address2.setCustomer(customer1);

		entityTransaction.begin();

		entityManager.persist(address1);
		entityManager.persist(address2);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}