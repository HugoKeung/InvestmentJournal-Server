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
	
	@NotNull
	private int shares;

	
	//@Past
	@NotNull
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private String date;
	
	@NotNull
	private String story;
	
	@NotNull
	private String strength;
	
	@NotNull
	private String weakness;
	
	@NotNull
	private String opportunity;
	
	@NotNull
	private String threat;
	
	
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getWeakness() {
		return weakness;
	}
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}
	public String getOpportunity() {
		return opportunity;
	}
	public void setOpportunity(String opportunity) {
		this.opportunity = opportunity;
	}
	public String getThreat() {
		return threat;
	}
	public void setThreat(String threat) {
		this.threat = threat;
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

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
