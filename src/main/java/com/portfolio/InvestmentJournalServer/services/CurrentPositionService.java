package com.portfolio.InvestmentJournalServer.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.InvestmentJournalServer.repositories.BuyPositionRepository;
import com.portfolio.InvestmentJournalServer.repositories.SellPositionRepository;

@Service
public class CurrentPositionService {
	
	private final BuyPositionRepository buyRepository;
	private final SellPositionRepository sellRepository;

	@Autowired
	public CurrentPositionService(BuyPositionRepository buyRepository, SellPositionRepository sellRepository) {
		this.buyRepository = buyRepository;
		this.sellRepository = sellRepository;;
	}
	
	
	
	
	
}
