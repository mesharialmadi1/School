package com.example.School.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target specifies the type of elements this will be used with
@Target({ElementType.FIELD,ElementType.PARAMETER})
//@Retention specifies when our annotation will be available
@Retention(RetentionPolicy.RUNTIME)
//@Constraint specifies the Class that will perform the validation
@Constraint(validatedBy = IsAlphabeticValidator.class)
public @interface IsAlphabetic {

//    String value();
    String message() default "Name must be valid";
//  the group of constraints
    public Class<?>[] groups() default {};
//  used to define payloads for the constraint
    public Class<? extends Payload>[] payload() default {};

}
