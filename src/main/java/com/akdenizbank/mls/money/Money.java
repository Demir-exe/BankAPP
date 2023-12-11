package com.akdenizbank.mls.money;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Money {

    

    public Money(Double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Currency currency;
}
