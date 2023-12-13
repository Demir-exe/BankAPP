package com.akdenizbank.mls.account.controller;

import com.akdenizbank.mls.xaction.UpdateBankAccountXAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.akdenizbank.mls.account.BankAccount;
import com.akdenizbank.mls.account.service.BankAccountService;
import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.money.Currency;
import com.akdenizbank.mls.money.Money;
import com.akdenizbank.mls.user.AppUser;
import com.akdenizbank.mls.user.service.AppUserService;

@RestController
@RequestMapping("/api/v1/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private AppUserService appUserService;
    
    @PostMapping("/{userid}")
    public GenericApiResponse createBankAccount(@PathVariable String userid) {
        AppUser appUserInDB = this.appUserService.getById(userid);
        if (appUserInDB == null) {
            throw new RuntimeException("No Such User");
        }
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAppuser(appUserInDB);
        appUserInDB.setBankaccount(bankAccount);
        bankAccountService.create(bankAccount);
        return new GenericApiResponse(200, "Success", "38974563", bankAccount);

    }

    // TODO: UPDATE BANK ACCOUNT METHOD - DONE !
    @PatchMapping("/{id}")
    public GenericApiResponse updateBankAccount(@PathVariable String id, @RequestBody UpdateBankAccountXAction xAction){
        BankAccount bankAccountInDB= bankAccountService.getById(id);
        if (  bankAccountInDB== null) {
            throw new RuntimeException("There is no such bank account");
        }

        bankAccountInDB.setDepositedmoney(xAction.getDepositedmoney());
        bankAccountInDB.setLinkedcards(xAction.getLinkedcards());
        bankAccountInDB=bankAccountService.create(bankAccountInDB);
        return new GenericApiResponse(200,"Success","123123",bankAccountInDB);
    }
    @GetMapping
    public GenericApiResponse getAllBankAccounts(Pageable pageable) {
        Page<BankAccount> bankAccountsPage = this.bankAccountService.getAll(pageable);
        return new GenericApiResponse(200, "Success", "29647532", bankAccountsPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getBankAccountById(@PathVariable String id) {
        BankAccount bankAccountInDB = this.bankAccountService.getById(id);
        if (bankAccountInDB == null) {
            throw new RuntimeException("No Such Bank Account");
        }
        return new GenericApiResponse(200, "Success", "13732854", bankAccountInDB);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteBankAccount(@PathVariable String id) {
        this.bankAccountService.delete(id);
        return new GenericApiResponse(200, "Success", "3984756");
    }
}
