package com.portfolio.InvestmentJournalServer.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;
import com.portfolio.InvestmentJournalServer.models.CurrentPosition;
import com.portfolio.InvestmentJournalServer.services.CurrentPositionService;

@RestController
@RequestMapping("api/positions/current")
public class CurrentPositionController {

	@Autowired
	private CurrentPositionService currentPositionService;
	
	@GetMapping
	public List<CurrentPosition> currentList(){
		return currentPositionService.getAll();

		
	}
	
	@GetMapping("/tickers")
	public String[] findCurrentTickers(){
		return currentPositionService.getCurrentTickers();
	}
	@GetMapping("/ticker/{ticker}")
	public List<BuyPosition> positionList(@PathVariable("ticker") String ticker){

		return currentPositionService.getBuyPosition(ticker);
	}
	
}
