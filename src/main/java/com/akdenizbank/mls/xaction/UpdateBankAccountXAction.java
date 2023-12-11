package com.akdenizbank.mls.xaction;

import com.akdenizbank.mls.card.BankCard;
import com.akdenizbank.mls.money.Money;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateBankAccountXAction {
    private Money depositedmoney;
    private Set<BankCard> linkedcards;
}
