package net.javaguides.springboot.ApplicationLayer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Repository.InterfaceUserRepository;
import net.javaguides.springboot.Service.UserServiceImplementation;

public class EmailDuplicateChecker implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private InterfaceUserRepository interfaceUserRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        User user = interfaceUserRepository.findByEmail(email);

        if (user != null && user.getEmail().equals(
                email)) {
            return false;
        }

        return user == null;
    }

}
