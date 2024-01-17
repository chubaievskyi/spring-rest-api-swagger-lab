package com.chubaievskyi.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class CustomValidator {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public boolean checkIpn(String ipn) {
        Set<ConstraintViolation<Object>> violations = validator.validate(ipn);
        return violations.isEmpty();
    }
}