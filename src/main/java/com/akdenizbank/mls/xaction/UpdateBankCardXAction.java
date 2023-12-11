package com.akdenizbank.mls.xaction;

import com.akdenizbank.mls.account.BankAccount;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateBankCardXAction {

    private String nameoncard;

    private String cardnumber;

    private Long expiredate;

    private int cvc;
}
