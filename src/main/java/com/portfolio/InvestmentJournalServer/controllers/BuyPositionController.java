package com.portfolio.InvestmentJournalServer.controllers;


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

import com.portfolio.InvestmentJournalServer.services.BuyPositionService;


@RestController
@RequestMapping("api/positions/buy")
public class BuyPositionController {
	
	
	@Autowired
	private BuyPositionService buyPositionService;

	
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
	

	@GetMapping("/{id}")
	public BuyPosition get(@PathVariable("id") long id) {
		return buyPositionService.singleBuyPosition(id);
	}

}
