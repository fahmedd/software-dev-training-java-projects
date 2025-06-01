package com.fdmgroup.manytomany.brokers;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Broker {

	@Id
	private int brokerId;
	private String name;

	@ManyToMany(mappedBy = "brokers")
	private List<StockExchange> stockExchanges;

	public Broker() {
	}

	public Broker(int brokerId, String name) {
		super();
		this.brokerId = brokerId;
		this.name = name;
	}

	public int getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StockExchange> getStockExchanges() {
		return stockExchanges;
	}

	public void setStockExchanges(List<StockExchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

}
