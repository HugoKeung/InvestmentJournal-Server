package com.portfolio.InvestmentJournalServer.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthController {

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;		
	}
}
