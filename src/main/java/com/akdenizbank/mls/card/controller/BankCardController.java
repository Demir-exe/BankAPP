package com.akdenizbank.mls.card.controller;

import com.akdenizbank.mls.xaction.UpdateBankCardXAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.akdenizbank.mls.card.BankCard;
import com.akdenizbank.mls.card.service.BankCardService;
import com.akdenizbank.mls.generic.rest.GenericApiResponse;

@RestController
@RequestMapping("/api/v1/bank-cards")
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    //TODO : CREATE BANK CARD METHOD  - DONE !
    //TODO : UPDATE BANK CARD METHOD  - DONE !
    @GetMapping
    public GenericApiResponse getAlBankCards(Pageable pageable) {
        Page<BankCard> bankCardsPage = this.bankCardService.getAll(pageable);
        return new GenericApiResponse(200, "Success", "345732945213", bankCardsPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getById(@PathVariable String id) {
        BankCard bankCardInDB = this.bankCardService.getById(id);
        if (bankCardInDB == null) {
            throw new RuntimeException("No Such Bank Card");
        }
        return new GenericApiResponse(200, "Success", "23097452893", bankCardInDB);
    }
    @PatchMapping("/{id}")
    public GenericApiResponse updateBankCard(@PathVariable String id, @RequestBody UpdateBankCardXAction xAction){
        BankCard bankCardInDB=this.bankCardService.getById(id);
        if (bankCardInDB == null) {
            throw new RuntimeException("No such bank card");
        }
        bankCardInDB.setNameoncard(xAction.getNameoncard());
        bankCardInDB.setCvc(xAction.getCvc());
        bankCardInDB.setExpiredate(xAction.getExpiredate());
        bankCardInDB.setCardnumber(xAction.getCardnumber());
        bankCardInDB=bankCardService.create(bankCardInDB);
        return new GenericApiResponse(200,"Success","123123",bankCardInDB);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteCard(@PathVariable String id) {
        this.bankCardService.delete(id);
        return new GenericApiResponse(200, "Success", "34265782");
    }

}
