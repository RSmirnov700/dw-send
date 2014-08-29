package com.dyn.api.dw.util;

import java.util.regex.Pattern;

public class SmtpValueValidator {
    private static final Pattern fqdnPattern =
            Pattern.compile("(?=^.{1,254}$)(^(?:(?!\\d+\\.|-)[a-zA-Z0-9_\\-]{1,63}(?<!-)\\.?)+(?:[a-zA-Z]{2,})$)",
                    Pattern.CASE_INSENSITIVE);

    private static final Pattern ipPattern =
            Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public boolean validate(String smtpValue) {
        return fqdnPattern.matcher(smtpValue).matches() || ipPattern.matcher(smtpValue).matches();
    }

}
