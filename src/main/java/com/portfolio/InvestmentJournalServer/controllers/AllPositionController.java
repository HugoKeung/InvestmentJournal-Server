package com.portfolio.InvestmentJournalServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.InvestmentJournalServer.models.SimplePosition;
import com.portfolio.InvestmentJournalServer.services.AllPositionService;

@RestController
@RequestMapping("api/positions/all")
public class AllPositionController {
	
	@Autowired
	private AllPositionService allPositionService;

	@GetMapping
	public List<SimplePosition> getAll(){
		return allPositionService.getAll();
		
	}

}
