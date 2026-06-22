package com.rishabh.order_management.CustomValidationAnnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidator
        implements ConstraintValidator<StrongPassword, String> {
    //<annotation type, field datatype>


    //validation method, called automatically by spring
    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext context) {

        if (password == null) {
            return false;
        }

        // minimum 8 characters
        if (password.length() < 8) {
            return false;
        }

        // uppercase check
        boolean hasUppercase =
                password.matches(".*[A-Z].*");//.* -> anything can be on left same for right

        // lowercase check
        boolean hasLowercase =
                password.matches(".*[a-z].*");

        // number check
        boolean hasNumber =
                password.matches(".*[0-9].*");

        // special character check
        boolean hasSpecialCharacter =
                password.matches(".*[@#$%^&+=!].*");

        return hasUppercase
                && hasLowercase
                && hasNumber
                && hasSpecialCharacter;
    }
}