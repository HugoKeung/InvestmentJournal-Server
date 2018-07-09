package com.portfolio.InvestmentJournalServer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.InvestmentJournalServer.models.SellPosition;
import com.portfolio.InvestmentJournalServer.repositories.SellPositionRepository;

@Service
public class SellPositionService {

	@Autowired
	private SellPositionRepository sellRepository;
	
	public List<SellPosition> findAll(){
		return sellRepository.findAll();
	}
	
	public void save(SellPosition sellPosition) {
		sellRepository.save(sellPosition);
	}
	
	public SellPosition getOne(long id) {
		return sellRepository.getOne(id);
	}
	
}
