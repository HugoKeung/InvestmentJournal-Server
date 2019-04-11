package com.portfolio.InvestmentJournalServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableResourceServer
public class InvestmentJournalServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentJournalServerApplication.class, args);
	}
}
