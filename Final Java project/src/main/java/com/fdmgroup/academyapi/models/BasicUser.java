package com.fdmgroup.academyapi.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "basic")
public class BasicUser extends User {
	@Column(name = "type", insertable = false, updatable = false)
	private String type = "basic";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
