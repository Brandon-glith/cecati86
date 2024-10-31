package net.javaguides.springboot.ApplicationLayer;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String names, ConstraintValidatorContext context) {

        if (names == null || names.isEmpty()) {
            return false;
        }
        String regex = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s.-]{2,}$";
        boolean valid = new CustomRegex(names, regex).valid();
        System.out.println("Are correct names: " + valid);
        return valid;
    }

}
