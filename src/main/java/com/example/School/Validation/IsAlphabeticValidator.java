package com.example.School.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

//    validator should implement the ConstraintValidator class
//    this class accepts 2 parameters, the validation interface and the parameter it attaches to
public class IsAlphabeticValidator implements ConstraintValidator<IsAlphabetic, String> {
//    the implementation of this interface class includes 2 methods, initialize() and isvalid
//    which should be overridden
    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "^[A-z]{2,15}\\s[A-z]{2,20}$";
        return Pattern.matches(regex, string);
    }
}
