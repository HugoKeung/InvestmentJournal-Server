package com.portfolio.InvestmentJournalServer.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "Sell_Position")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SellPosition {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max=4)
	private String ticker;
	
	@NotNull
	private BigDecimal price;
	
	@NotNull
	private int shares;
	
	@NotNull
//	@Past
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private String date;
	
	@NotNull
	@Column(name="sell_reason")
	private String sellReason;
	
	@NotNull
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUser_id(String userId) {
		this.userId = userId;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
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
	public String getSellReason() {
		return sellReason;
	}
	public void setSellReason(String sellReason) {
		this.sellReason = sellReason;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
