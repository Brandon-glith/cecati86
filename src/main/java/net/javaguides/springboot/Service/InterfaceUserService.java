package net.javaguides.springboot.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.DTO.ApplicantInfoDTO;
import net.javaguides.springboot.DTO.NewsDTO;
import net.javaguides.springboot.DTO.RegisterCourseDTO;
import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.Rol;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Repository.InterfaceUserRepository;

public interface InterfaceUserService extends UserDetailsService {
    User save(UserRegistrationDTO registrationDTO, Long rolId);

    List<User> findAllByRoleId(Long id);

    void changePasswordByEmail(String email,
            String password);

    void signUpCourse(RegisterCourseDTO courseDTO);

    Long getNewApplicants();

    Boolean itIsRegistered(RegisterCourseDTO registerCourseDTO);

    List<ApplicantInfoDTO> getAllApplicantInfoDTOs();

    void deleteApplicantById(Long id);

    
}
