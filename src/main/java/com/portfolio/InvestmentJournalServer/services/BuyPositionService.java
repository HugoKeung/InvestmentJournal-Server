package com.portfolio.InvestmentJournalServer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;
import com.portfolio.InvestmentJournalServer.repositories.BuyPositionRepository;

@Service
public class BuyPositionService {

	@Autowired 
	private BuyPositionRepository  buyRepository;
	
	public BuyPosition singleBuyPosition(long id) {
		return buyRepository.getOne(id);
	}
	
	public void saveBuyPosition(BuyPosition buyPosition) {
		buyRepository.save(buyPosition);
	}
	
	public List<BuyPosition> getAll(){
		return buyRepository.findAll();
	}
}

