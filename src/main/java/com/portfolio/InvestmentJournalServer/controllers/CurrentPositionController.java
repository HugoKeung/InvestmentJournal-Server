package com.portfolio.InvestmentJournalServer.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public List<CurrentPosition> currentList(Principal principal){
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String principal = authentication.getPrincipal().toString();
//		this.user_id = principal.substring(principal.lastIndexOf("|")+1);
	
		String principal_id = principal.getName();
		String user_id = principal_id.substring(principal_id.lastIndexOf("|")+1);

		return currentPositionService.getAll(user_id);

		
	}
	
	//get list of tickers (only) of the user
	@GetMapping("/tickers")
	public String[] findCurrentTickers(Principal principal){
		String principal_id = principal.getName();
		String user_id = principal_id.substring(principal_id.lastIndexOf("|")+1);
		
		return currentPositionService.getCurrentTickers(user_id);
	}
	
	//get detail associated with the ticker of user
	@GetMapping("/ticker/{ticker}")
	public List<BuyPosition> positionList(@PathVariable("ticker") String ticker, Principal principal){
		String principal_id = principal.getName();
		String user_id = principal_id.substring(principal_id.lastIndexOf("|")+1);
		
		return currentPositionService.getBuyPositions(ticker, user_id);
	}
	
}
