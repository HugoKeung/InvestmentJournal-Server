package com.portfolio.InvestmentJournalServer.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;

public interface BuyPositionRepository extends JpaRepository<BuyPosition, Long> {
	
	@Query("select b.ticker from BuyPosition b")
	public String[] findCurrentTickers();
	
}
