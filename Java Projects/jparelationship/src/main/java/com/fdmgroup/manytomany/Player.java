package com.fdmgroup.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Player {

	@Id
	private int playerId;
	private String playerName;

	@ManyToMany(mappedBy="listPlayers")
	private List<Team> listTeams;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<Team> getListTeams() {
		return listTeams;
	}

	public void setListTeams(List<Team> listTeams) {
		this.listTeams = listTeams;
	}

}
