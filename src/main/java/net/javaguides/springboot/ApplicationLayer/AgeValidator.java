package net.javaguides.springboot.ApplicationLayer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeValidator implements ConstraintValidator<ValidAge, LocalDate> {

    @Override
    public boolean isValid(LocalDate birthdate, ConstraintValidatorContext context) {

        if (birthdate == null) {
            return false;
        }

        LocalDate now = LocalDate.now();
        byte age = (byte) (Period.between(
                birthdate,
                now).getYears());

        return age >= 15;
    }

}
