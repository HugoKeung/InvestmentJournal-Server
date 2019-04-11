package com.portfolio.InvestmentJournalServer.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;

public interface BuyPositionRepository extends JpaRepository<BuyPosition, Long> {
	
	@Query("select ticker from BuyPosition where userId = ?#{[0]}")
	public String[] findCurrentTickers(String userId);
	
	@Query("select coalesce(sum(shares), 0) from BuyPosition where ticker = ?#{[0]}")
	public int findNumberOfShares(String ticker);

	public List<BuyPosition> findAllByOrderByDateDesc();
	
	public List<BuyPosition> findByTickerAndUserId(String ticker, String userId);
	
	@Query("select coalesce(sum(price* shares),0) from BuyPosition where ticker = ?#{[0]}")
	public BigDecimal buyPrice(String ticker);
	

}
