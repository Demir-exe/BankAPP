package com.akdenizbank.mls.card.controller;

import com.akdenizbank.mls.card.BankCard;
import com.akdenizbank.mls.card.service.BankCardService;
import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.xaction.CreateBankCardXAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bankcard-registration")
public class BankCardCreateController {

    @Autowired
    BankCardService bankCardService;
    @PostMapping("/create")
    public GenericApiResponse createBankCard(@RequestBody CreateBankCardXAction xAction){
        BankCard bankCard=new BankCard();
        bankCard.setNameoncard(xAction.getNameoncard());
        bankCard.setCvc(xAction.getCvc());
        bankCard.setCardnumber(xAction.getCardnumber());
        bankCard.setExpiredate(xAction.getExpiredate());
        bankCard=this.bankCardService.create(bankCard);
        return new GenericApiResponse(200,"Success","123123",bankCard);

    }
}
