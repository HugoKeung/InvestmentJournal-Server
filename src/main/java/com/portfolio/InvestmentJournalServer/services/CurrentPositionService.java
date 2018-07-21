package com.portfolio.InvestmentJournalServer.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;
import com.portfolio.InvestmentJournalServer.models.CurrentPosition;
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
	
	private int currentShares(String ticker){
		int bought = buyRepository.findNumberOfShares(ticker);
		int sold = sellRepository.findNumberOfShares(ticker);

		return bought - sold;
	}
	

	
	
	public List<CurrentPosition> getAll(){
	
		List<BuyPosition> buyList =  buyRepository.findAllByOrderByDateDesc();
	
		List<CurrentPosition> currentList = new ArrayList<>();
	//prevent duplicate ticker;
		List<String> matchingList = new ArrayList<>();
	
			for(BuyPosition buy: buyList) {
				String ticker = buy.getTicker();

				String date = buy.getDate();
				int shares = currentShares(ticker);
				BigDecimal buyPrice = buyRepository.buyPrice(ticker);
				BigDecimal sellPrice = sellRepository.sellPrice(ticker);


				if (!matchingList.contains(ticker) && shares >0){
					currentList.add(new CurrentPosition(ticker, shares, date, buyPrice, sellPrice));
					matchingList.add(ticker);
				}

			}

		return currentList;
	
	}
	
	public String[] getCurrentTickers() {
		return buyRepository.findCurrentTickers();
	}
	
	
	public List<BuyPosition> getBuyPosition(String ticker){
		return buyRepository.findByTicker(ticker);
		
	}
	
}
