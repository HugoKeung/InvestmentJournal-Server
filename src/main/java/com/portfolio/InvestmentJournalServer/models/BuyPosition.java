package com.portfolio.InvestmentJournalServer.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BuyPosition {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	

	private String ticker;
	private String price;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MMyyyy")
	private String date;
	
	@Column(name="buy_reason")
	private String buyReason;
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBuyReason() {
		return buyReason;
	}
	public void setBuyReason(String buyReason) {
		this.buyReason = buyReason;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
