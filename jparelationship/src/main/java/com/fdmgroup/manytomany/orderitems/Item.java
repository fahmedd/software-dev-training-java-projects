package com.fdmgroup.manytomany.orderitems;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item {

	@Id
	private int itemId;
	private String itemName;

	// this mappedBy attribute says "refer to the listItems variable" in the Order class
	@ManyToMany(mappedBy = "listItems")
	private List<Order> listOrders;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public List<Order> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Order> listOrders) {
		this.listOrders = listOrders;
	}

}
