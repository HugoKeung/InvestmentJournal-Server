package com.portfolio.InvestmentJournalServer.controllers;


import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public String createBuyPosition(@Valid @RequestBody BuyPosition buyPosition, BindingResult result, Principal principal) {
			String principal_id = principal.getName();
			String user_id = principal_id.substring(principal_id.lastIndexOf("|")+1);
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String principaal = authentication.getPrincipal().toString();
//		String user_id = principaal.substring(principaal.lastIndexOf("|")+1);


		if(result.hasErrors()) {
			System.out.println("save buy psotition has error");
			System.out.println(result);
			return result.getFieldError().getField();
		}
		else {
			System.out.println("save buy position");
			buyPosition.setUserId(user_id);
			buyPositionService.saveBuyPosition(buyPosition);
			return "";
		}
	}
	
//TODO: Test below function
	@GetMapping("/{id}")
	public BuyPosition get(@PathVariable("id") long id, Principal principal) {
		String principal_id = principal.getName();
		String user_id = principal_id.substring(principal_id.lastIndexOf("|")+1);
		
		BuyPosition request = buyPositionService.singleBuyPosition(id);
		
		if (request.getUserId().equals(user_id)){
			return request;
		}
		else return null;

	}

}
