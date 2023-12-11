package com.akdenizbank.mls.account.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.account.BankAccount;
import com.akdenizbank.mls.account.repository.BankAccountRepository;

@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount create(BankAccount bankAccount) {
        return this.bankAccountRepository.save(bankAccount);
    }

    public BankAccount getById(String id) {
        return this.bankAccountRepository.findById(id).orElse(null);
    }

    public Page<BankAccount> getAll(Pageable pageable) {
        return this.bankAccountRepository.findAll(pageable);
    }

    public void delete(String id) {
        BankAccount bankAccountInDB = this.getById(id);
        if (bankAccountInDB == null) {
            throw new RuntimeException("No Such Bank Account");
        }
        bankAccountRepository.delete(bankAccountInDB);
    }
}
