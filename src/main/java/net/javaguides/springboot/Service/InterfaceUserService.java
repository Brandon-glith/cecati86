package net.javaguides.springboot.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Repository.InterfaceUserRepository;

public interface InterfaceUserService extends UserDetailsService{
    User save(UserRegistrationDTO registrationDTO);
}
