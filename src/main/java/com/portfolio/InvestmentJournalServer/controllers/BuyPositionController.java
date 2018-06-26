package com.portfolio.InvestmentJournalServer.controllers;

import java.util.ArrayList;
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
import com.portfolio.InvestmentJournalServer.repositories.BuyPositionRepository;

@RestController
@RequestMapping("api/positions/buy")
public class BuyPositionController {
	
	@Autowired
	private BuyPositionRepository buyPositionRepository;
	
	@GetMapping
	public List<BuyPosition> list(){
		return buyPositionRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void createBuyPosition(@RequestBody BuyPosition buyPosition) {
		buyPositionRepository.save(buyPosition);
	}
	
	@GetMapping("/{id}")
	public BuyPosition get(@PathVariable("id") long id) {
		return buyPositionRepository.getOne(id);
	}

}
