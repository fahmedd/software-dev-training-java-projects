package com.fdmgroup.manytoone;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	private int customerId;
	private String customerName;

	@OneToMany(mappedBy = "customer")
	private List<Address> listAddresses;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Address> getListAddresses() {
		return listAddresses;
	}

	public void setListAddresses(List<Address> listAddresses) {
		this.listAddresses = listAddresses;
	}

}
