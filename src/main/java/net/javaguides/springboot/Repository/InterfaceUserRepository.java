package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.User;

@Repository
public interface InterfaceUserRepository extends JpaRepository<User, Long>{
    
}