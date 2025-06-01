package com.fdmgroup.manytomany;

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

		Team team1 = new Team();
		team1.setTeamId(1);
		team1.setTeamName("LIV");

		Team team2 = new Team();
		team2.setTeamId(2);
		team2.setTeamName("MANU");

		Player player1 = new Player();
		player1.setPlayerId(1);
		player1.setPlayerName("A");

		Player player2 = new Player();
		player2.setPlayerId(2);
		player2.setPlayerName("B");

		List<Player> listBigPlayers = new ArrayList<Player>(Arrays.asList(player1, player2));
		team1.setListPlayers(listBigPlayers);

		List<Player> listSmallPlayers = new ArrayList<Player>(Arrays.asList(player1));
		team2.setListPlayers(listSmallPlayers);

		entityTransaction.begin();

		entityManager.persist(team1);
		entityManager.persist(team2);

		entityTransaction.commit();

		entityManager.close();
		entityManagerFactory.close();
		


	}
}