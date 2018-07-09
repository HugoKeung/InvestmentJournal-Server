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

import com.portfolio.InvestmentJournalServer.models.SellPosition;
import com.portfolio.InvestmentJournalServer.services.SellPositionService;

@RestController
@RequestMapping("api/positions/sell")

public class SellPositionController {
	
	@Autowired
	private SellPositionService sellPositionService;
	
	@GetMapping
	public List<SellPosition> list(){
		return sellPositionService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public String createSellPosition(@Valid @RequestBody SellPosition sellPosition, BindingResult result) {
		if(result.hasErrors()) {
	
			return result.getFieldError().getField();
		}
		else {
			sellPositionService.save(sellPosition);
			return "";
		}
		
	}
	
	@GetMapping("/{id}")
	public SellPosition get(@PathVariable("id") long id) {
		return sellPositionService.getOne(id);
	}

	
}
