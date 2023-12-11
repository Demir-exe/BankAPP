package com.akdenizbank.mls.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akdenizbank.mls.card.BankCard;

public interface BankCardRepository extends JpaRepository<BankCard, String> {

}
