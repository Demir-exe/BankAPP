package com.akdenizbank.mls.user;

import org.hibernate.annotations.GenericGenerator;

import com.akdenizbank.mls.account.BankAccount;
import com.akdenizbank.mls.util.StringSequenceIdentifier;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class AppUser {

    @Id
    @GenericGenerator(name = "random-15", type = StringSequenceIdentifier.class, parameters = @org.hibernate.annotations.Parameter(name = "length", value = "15"))
    @GeneratedValue(generator = "random-15")
    protected String id;

    protected String name;

    protected String surname;

    protected String email;

    @OneToOne(mappedBy = "appuser", cascade = CascadeType.ALL)
    protected BankAccount bankaccount;
    
}
