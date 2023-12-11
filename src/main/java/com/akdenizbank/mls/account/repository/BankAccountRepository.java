package com.akdenizbank.mls.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akdenizbank.mls.account.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
