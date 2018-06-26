package com.portfolio.InvestmentJournalServer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.InvestmentJournalServer.models.SellPosition;

public interface SellPositionRepository extends JpaRepository<SellPosition, Long> {

}
