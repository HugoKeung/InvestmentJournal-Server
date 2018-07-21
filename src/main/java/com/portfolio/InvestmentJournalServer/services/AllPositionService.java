package com.portfolio.InvestmentJournalServer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;
import com.portfolio.InvestmentJournalServer.models.SellPosition;
import com.portfolio.InvestmentJournalServer.models.SimplePosition;
import com.portfolio.InvestmentJournalServer.repositories.BuyPositionRepository;
import com.portfolio.InvestmentJournalServer.repositories.SellPositionRepository;

@Service
public class AllPositionService {

	private final BuyPositionRepository buyRepository;
	private final SellPositionRepository sellRepository;

	@Autowired
	public AllPositionService(BuyPositionRepository buyRepository, SellPositionRepository sellRepository) {
		this.buyRepository = buyRepository;
		this.sellRepository = sellRepository;;
	}
	
	public List<SimplePosition> getAll(){
		List<SimplePosition> list = new ArrayList<>();
		List<BuyPosition> buyList = buyRepository.findAll();
		List<SellPosition> sellList = sellRepository.findAll();
		
		for (BuyPosition pos: buyList) {
			//sel flag = true, because true is flaag for Buy
			SimplePosition buy = new SimplePosition(pos.getId(), pos.getTicker(), pos.getDate(), pos.getShares(), pos.getPrice(), "buy");
			list.add(buy);
		}
		for (SellPosition pos: sellList) {
			//sel flag = true, because true is flaag for Buy
			SimplePosition sell = new SimplePosition(pos.getId(), pos.getTicker(), pos.getDate(), pos.getShares(), pos.getPrice(), "sell");
			list.add(sell);
		}
		
		return list;
	}
	
}
