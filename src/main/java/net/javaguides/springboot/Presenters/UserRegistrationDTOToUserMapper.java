package net.javaguides.springboot.Presenters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Models.User;

@Component
public class UserRegistrationDTOToUserMapper implements InterfaceDTOToEntityMapper<UserRegistrationDTO, User> {

    @Autowired
    private BCryptPasswordEncoder eBCryptPasswordEncoder;

    @Override
    public User convertToEntity(UserRegistrationDTO registrationDTO) {
        User user = new User();

        user.setName(registrationDTO.getNames());
        user.setLastName(registrationDTO.getSurnames());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(eBCryptPasswordEncoder.encode(
                registrationDTO.getPassword()));
        return user;
    }

}
