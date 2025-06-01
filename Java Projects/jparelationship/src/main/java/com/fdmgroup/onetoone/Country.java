package com.fdmgroup.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Country {

	@Id
	private int countryId;
	private String name;
	
	@OneToOne(cascade = CascadeType.PERSIST)  
	@JoinColumn(name = "leader_id")
	private Leader leader;
	
	public Country() {}
	
	public Country(int countryId, String name, Leader leader) {
		super();
		this.countryId = countryId;
		this.name = name;
		this.leader = leader;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Leader getLeader() {
		return leader;
	}

	public void setLeader(Leader leader) {
		this.leader = leader;
	}
	
}
