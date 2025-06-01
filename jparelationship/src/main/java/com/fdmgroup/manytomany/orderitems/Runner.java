package com.fdmgroup.manytomany.orderitems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Runner {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jparelationship");

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Order order1 = new Order();
		order1.setOrderId(1);
		order1.setOrderName("order1");

		Order order2 = new Order();
		order2.setOrderId(2);
		order2.setOrderName("order2");

		Item item1 = new Item();
		item1.setItemId(1);
		item1.setItemName("item1");

		Item item2 = new Item();
		item2.setItemId(2);
		item2.setItemName("item2");

		List<Item> listBigItems = new ArrayList<Item>(Arrays.asList(item1, item2));
		order1.setListItems(listBigItems);

		List<Item> listSmallItems = new ArrayList<Item>(Arrays.asList(item1));
		order2.setListItems(listSmallItems);

		entityTransaction.begin();

		entityManager.persist(order1);
		entityManager.persist(order2);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}