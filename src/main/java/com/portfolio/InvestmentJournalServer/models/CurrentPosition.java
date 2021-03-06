package com.portfolio.InvestmentJournalServer.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class CurrentPosition {
	
	private String ticker;
	private int shares;
	private String date;
	private BigDecimal buyPrice;
	
//Sell price is to show position already sold.
	private BigDecimal sellPrice;

	@NotNull
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BigDecimal getSellPrice() {
		return sellPrice;
	}


	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}


	public BigDecimal getBuyPrice() {
		return buyPrice;
	}


	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}


	public CurrentPosition(String ticker, int shares, String date, BigDecimal buyPrice, BigDecimal sellPrice, String user_id){
		this.ticker = ticker;
		this.shares = shares;
		this.date = date;
		this.buyPrice = buyPrice;
		this.userId = user_id;
	}
	
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}



	

}
