package com.portfolio.InvestmentJournalServer.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BuyPosition {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max=4)
	private String ticker;
	
	@NotNull
	private BigDecimal price;
	
	
	
	//@Past
	@NotNull
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private String date;
	
	@NotNull
	@Column(name="buy_reason")
	private String buyReason;
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
