package com.portfolio.InvestmentJournalServer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.InvestmentJournalServer.models.BuyPosition;

public interface BuyPositionRepository extends JpaRepository<BuyPosition, Long> {

}
