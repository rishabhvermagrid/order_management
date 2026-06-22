package com.hamza.order_management.CustomValidationAnnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented//Makes annotation visible in generated javaDocs, Tools in menu bar -> generate doc
@Constraint(validatedBy = StrongPasswordValidator.class)//Use this validator class for validation logic.
@Target(ElementType.FIELD)//Defines where annotations can be used, (method,parameter,type)
@Retention(RetentionPolicy.RUNTIME)//keeps annotation available during runtime, without this: Spring can't read annotation while application runs
public @interface StrongPassword {

    String message() default
            "Password must contain uppercase, lowercase, number, special character and minimum 8 characters";
    //default validation error message

    Class<?>[] groups() default {};//Used to apply validations conditionally for different operations
    //like Create, Update,

    Class<? extends Payload>[] payload() default {};//used to attach metadata to validation errors, allows adding extra information , severity level : error category :
    //warning vs critical
}