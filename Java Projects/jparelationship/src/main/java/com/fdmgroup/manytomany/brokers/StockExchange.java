package com.fdmgroup.manytomany.brokers;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class StockExchange {

	@Id
	private int stockExId;
	private String name;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable
	(
			name = "broker_stock_ex", 
			joinColumns = @JoinColumn(name = "stock_ex_id"), 
			inverseJoinColumns = @JoinColumn(name = "broker_id")
	)
	private List<Broker> brokers;
	
	public StockExchange() {}
	
	public StockExchange(int stockExId, String name, List<Broker> brokers) {
		super();
		this.stockExId = stockExId;
		this.name = name;
		this.brokers = brokers;
	}

	public int getStockExId() {
		return stockExId;
	}

	public void setStockExId(int stockExId) {
		this.stockExId = stockExId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Broker> getBrokers() {
		return brokers;
	}

	public void setBrokers(List<Broker> brokers) {
		this.brokers = brokers;
	}
	
	
	
}
