package com.portfolio.InvestmentJournalServer.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<SimplePosition> getAll(Principal principal){
		String principal_id = principal.getName();
		String user_id = principal_id.substring(principal_id.lastIndexOf("|")+1);

		return allPositionService.getAll(user_id);
		
	}

}
