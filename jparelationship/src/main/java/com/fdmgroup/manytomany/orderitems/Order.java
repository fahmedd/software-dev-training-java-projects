package com.fdmgroup.manytomany.orderitems;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="sc_order")
public class Order {

	@Id
	private int orderId;
	private String orderName;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable
	(
			name = "ORDER_ITEM", // join table name
			joinColumns = @JoinColumn(name = "order_id"),      // PK in this table
			inverseJoinColumns = @JoinColumn(name = "item_id") // PK in other table
	)
	private List<Item> listItems;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<Item> getListItems() {
		return listItems;
	}

	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}

	
	
	

}
