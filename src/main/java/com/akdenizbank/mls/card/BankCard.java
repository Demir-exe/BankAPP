package com.akdenizbank.mls.card;

import org.hibernate.annotations.GenericGenerator;

import com.akdenizbank.mls.account.BankAccount;
import com.akdenizbank.mls.util.StringSequenceIdentifier;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankCard {

    @Id
    @GenericGenerator(name = "random-15", type = StringSequenceIdentifier.class, parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    @ManyToOne
    @JoinColumn(name = "bankaccount_id")
    @JsonIgnore
    private BankAccount bankaccount;

    private String nameoncard;

    private String cardnumber;

    private Long expiredate;

    private int cvc;
}
