package com.akdenizbank.mls.account;

import java.util.Set;

import org.hibernate.annotations.GenericGenerator;

import com.akdenizbank.mls.card.BankCard;
import com.akdenizbank.mls.money.Money;
import com.akdenizbank.mls.user.AppUser;
import com.akdenizbank.mls.user.CustomerUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BankAccount {

    @Id
    @GenericGenerator(name = "random-15", strategy = "com.akdenizbank.mls.util.StringSequenceIdentifier", parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    private String id;

    @OneToMany(mappedBy = "bankaccount", cascade = CascadeType.REMOVE)
    private Set<BankCard> linkedcards;

    @Embedded
    private Money depositedmoney;

    @OneToOne
    @JoinColumn(name = "appuser_id")
    @JsonIgnore
    private AppUser appuser;
}
