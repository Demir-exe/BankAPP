package com.akdenizbank.mls.util;

import java.util.regex.Pattern;

public class Validation {

    public static boolean emailMatcher(String emailAddress) {
        return Pattern.compile(
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                .matcher(emailAddress).matches();
    }
}
