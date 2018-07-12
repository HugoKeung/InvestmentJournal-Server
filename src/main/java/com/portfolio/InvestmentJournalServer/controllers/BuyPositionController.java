package com.portfolio.InvestmentJournalServer.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;
import com.portfolio.InvestmentJournalServer.models.CurrentPosition;
import com.portfolio.InvestmentJournalServer.services.BuyPositionService;
import com.portfolio.InvestmentJournalServer.services.CurrentPositionService;

@RestController
@RequestMapping("api/positions/buy")
public class BuyPositionController {
	
	@Autowired
	private CurrentPositionService currentPositionService;
	
	@Autowired
	private BuyPositionService buyPositionService;


	
	@GetMapping("/current")
	public List<CurrentPosition> currentList(){
		return currentPositionService.getAll();
	}
	
	@GetMapping("/ticker/{ticker}")
	public List<BuyPosition> positionList(@PathVariable("ticker") String ticker){

		return currentPositionService.getBuyPosition(ticker);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public String createBuyPosition(@Valid @RequestBody BuyPosition buyPosition, BindingResult result) {
		if(result.hasErrors()) {
			return result.getFieldError().getField();
		}
		else {
			buyPositionService.saveBuyPosition(buyPosition);
			return "";
		}
	}
	
	@GetMapping("/tickers")
	public String[] findCurrentTickers(){
		return currentPositionService.getCurrentTickers();
	}
	
	@GetMapping("/{id}")
	public BuyPosition get(@PathVariable("id") long id) {
		return buyPositionService.singleBuyPosition(id);
	}

}
