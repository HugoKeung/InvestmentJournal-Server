package com.portfolio.InvestmentJournalServer.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.InvestmentJournalServer.models.SellPosition;

public interface SellPositionRepository extends JpaRepository<SellPosition, Long> {

	@Query("select coalesce(sum(s.shares), 0) from SellPosition s where s.ticker = ?#{[0]}")
	public int findNumberOfShares(String ticker);
	
	@Query("select coalesce(sum(price* shares),0) from SellPosition where ticker = ?#{[0]}")
	public BigDecimal sellPrice(String ticker);
	
}
