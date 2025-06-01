package com.fdmgroup.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Leader {

	@Id
	private int leaderId;
	private String name;
	
	@OneToOne(mappedBy = "leader")  // bi-directional relationship
	private Country country;
	
	public Leader() {}

	public Leader(int leaderId, String name) {
		super();
		this.leaderId = leaderId;
		this.name = name;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	

	
}
