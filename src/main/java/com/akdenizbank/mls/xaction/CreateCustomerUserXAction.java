package com.akdenizbank.mls.xaction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCustomerUserXAction {

    private String name;

    private String surname;

    private String email;
}
