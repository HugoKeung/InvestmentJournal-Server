package com.portfolio.InvestmentJournalServer.models;

import java.math.BigDecimal;

public class SimplePosition {

	//id of the original table. this is needed to retrieve data and show more detail
	private long id;


	private String ticker;
	private String date;
	private int shares;
	private BigDecimal price;


	private String flag;
	
	public SimplePosition(long id, String ticker, String date, int shares, BigDecimal price, String flag) {
		this.id = id;
		this.ticker = ticker;
		this.date = date;
		this.shares = shares;
		this.price = price;
		this.flag = flag;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}