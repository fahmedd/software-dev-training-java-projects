package com.fdmgroup.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Team {

	@Id
	private int teamId;
	private String teamName;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable
	//(name = "TEAM_PLAYER", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
	private List<Player> listPlayers;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Player> getListPlayers() {
		return listPlayers;
	}

	public void setListPlayers(List<Player> listPlayers) {
		this.listPlayers = listPlayers;
	}

}
