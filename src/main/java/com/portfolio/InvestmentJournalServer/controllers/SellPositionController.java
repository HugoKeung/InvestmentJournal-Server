package com.portfolio.InvestmentJournalServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;
import com.portfolio.InvestmentJournalServer.models.SellPosition;
import com.portfolio.InvestmentJournalServer.repositories.SellPositionRepository;

@RestController
@RequestMapping("api/positions/sell")

public class SellPositionController {
	
	@Autowired
	private SellPositionRepository sellPositionRepository;
	
	@GetMapping
	public List<SellPosition> list(){
		return sellPositionRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createSellPosition(@RequestBody SellPosition sellPosition) {
		sellPositionRepository.save(sellPosition);
	}
	
	@GetMapping("/{id}")
	public SellPosition get(@PathVariable("id") long id) {
		return sellPositionRepository.getOne(id);
	}

	
}
