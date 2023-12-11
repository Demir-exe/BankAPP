package com.akdenizbank.mls.xaction;

import com.akdenizbank.mls.user.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateEmployeeUserXAction  {
    private String email;
}
