package com.chubaievskyi.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class IpnValidator implements ConstraintValidator<IpnValidation, String> {

    public final Pattern pattern = Pattern.compile("\\b\\d{10}\\b");
    public final int[] coefficient = {-1, 5, 7, 9, 4, 6, 10, 5, 7};

    @Override
    public boolean isValid(String ipn, ConstraintValidatorContext context) {

        if (ipn == null || !pattern.matcher(ipn).matches()) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < ipn.length() - 1; i++) {
            sum += Integer.parseInt(String.valueOf(ipn.charAt(i))) * coefficient[i];
        }

        int calculatedControlDigit = (sum % 11) % 10;
        int controlDigit = Integer.parseInt(String.valueOf(ipn.charAt(ipn.length() - 1)));
        return calculatedControlDigit == controlDigit;
    }
}