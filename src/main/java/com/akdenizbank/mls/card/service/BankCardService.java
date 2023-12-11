package com.akdenizbank.mls.card.service;

import javax.management.RuntimeErrorException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.card.BankCard;
import com.akdenizbank.mls.card.repository.BankCardRepository;

@Service
public class BankCardService {

    private BankCardRepository bankCardRepository;

    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    public BankCard create(BankCard bankCard) {
        return this.bankCardRepository.save(bankCard);
    }

    public BankCard getById(String id) {
        return this.bankCardRepository.findById(id).orElse(null);
    }

    public Page<BankCard> getAll(Pageable pageable) {
        return this.bankCardRepository.findAll(pageable);
    }

    public void delete(String id) {
        BankCard cardInDB = this.getById(id);
        if (cardInDB == null) {
            throw new RuntimeException("No Such Bank Card");
        }
        this.bankCardRepository.delete(cardInDB);
    }
}
