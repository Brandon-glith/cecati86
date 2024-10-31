package net.javaguides.springboot.ApplicationLayer;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        if (email == null || email.isEmpty()) {
            return false;
        }
        return new CustomRegex(email, regex).valid();
    }

}
