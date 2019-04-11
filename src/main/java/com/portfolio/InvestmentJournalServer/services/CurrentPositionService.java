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
	

	
	
	public List<CurrentPosition> getAll(String userId){

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
				String user_id = buy.getUserId();


				if (!matchingList.contains(ticker) && shares >0 && user_id.equals(userId)){
					currentList.add(new CurrentPosition(ticker, shares, date, buyPrice, sellPrice, user_id));
					matchingList.add(ticker);
				}

			}
		
		return currentList;
	
	}
	
	public String[] getCurrentTickers(String userId) {
		return buyRepository.findCurrentTickers(userId);

	}
	
	
	public List<BuyPosition> getBuyPositions(String ticker, String userId){

		return buyRepository.findByTickerAndUserId(ticker, userId);
		
	}
	
}
