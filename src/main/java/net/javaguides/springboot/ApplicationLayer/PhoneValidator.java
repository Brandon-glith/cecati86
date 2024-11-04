package net.javaguides.springboot.ApplicationLayer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        String regex = "^(\\+52)?\\s?\\(?\\d{2,3}\\)?\\s?\\d{7,8}$";

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }

        return new CustomRegex(phoneNumber, regex).valid();
    }

}
