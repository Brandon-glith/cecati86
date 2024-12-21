package net.javaguides.springboot.Service;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTO.ApplicantInfoDTO;
import net.javaguides.springboot.DTO.RegisterCourseDTO;
import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Detail.CustomUserDetails;
import net.javaguides.springboot.Models.Administrator;
import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.Course;
import net.javaguides.springboot.Models.DepartamentUser;
import net.javaguides.springboot.Models.Rol;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Presenters.ApplicantToApplicantInfoDTO;
import net.javaguides.springboot.Presenters.UserRegistrationDTOToUserMapper;
import net.javaguides.springboot.Repository.InterfaceCourseRepository;
import net.javaguides.springboot.Repository.InterfaceRolRepository;
import net.javaguides.springboot.Repository.InterfaceUserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements InterfaceUserService {

    @Autowired
    private InterfaceUserRepository userRepository;
    @Autowired
    private InterfaceRolRepository rolRepository;
    @Autowired
    private BCryptPasswordEncoder eBCryptPasswordEncoder;

    @Autowired
    UserRegistrationDTOToUserMapper dtoToUserMapper;

    @Autowired
    InterfaceCourseRepository courseRepository;

    @Autowired
    ApplicantToApplicantInfoDTO applicantToApplicantInfoDTO;

    @Override
    public User save(UserRegistrationDTO registrationDTO, Long rolId) {
        Optional<Rol> optionalRol = rolRepository.findById(rolId);

        // Verificamos si el Rol existe
        if (optionalRol.isPresent()) {
            Rol rol = optionalRol.get();
            // Creamos el usuario Applicant
            int idRol = rol.getId().intValue();

            User user = dtoToUserMapper.convertToEntity(registrationDTO);

            switch (idRol) {
                case 1:
                    Applicant aspirantUser = new Applicant();
                    // Establecemos los valores en aspirantUser tomando primero los ya configurados
                    // en user
                    aspirantUser.setName(user.getName());
                    aspirantUser.setLastName(user.getLastName());
                    aspirantUser.setEmail(user.getEmail());
                    aspirantUser.setPassword(user.getPassword());

                    // Establecemos los atributos adicionales de aspirantUser desde registrationDTO
                    aspirantUser.setBirthdate(registrationDTO.getBirthdate());
                    aspirantUser.setPhoneNumber(registrationDTO.getPhoneNumber());
                    aspirantUser.setRol(rol);
                    return userRepository.save(aspirantUser);

                case 3:
                    DepartamentUser departamentUser = new DepartamentUser();
                    departamentUser.setName(user.getName());
                    departamentUser.setLastName(user.getLastName());
                    departamentUser.setEmail(user.getEmail());
                    departamentUser.setPassword(user.getPassword());
                    departamentUser.setRol(rol);
                    return userRepository.save(departamentUser);

                case 2:
                    Administrator administrator = new Administrator();
                    administrator.setName(user.getName());
                    administrator.setLastName(user.getLastName());
                    administrator.setEmail(user.getEmail());
                    administrator.setPassword(user.getPassword());
                    administrator.setRol(rol);
                    return userRepository.save(administrator);

                default:
                    break;
            }

            // Establecemos los atributos adicionales del Applicant

            // Guardamos el usuario en la base de datos y lo retornamos
            return userRepository.save(user);
        } else {
            // Si el Rol no se encuentra, puedes lanzar una excepción
            throw new RuntimeException("Rol no encontrado");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(
                email);

        if (user == null) {
            throw new UsernameNotFoundException(
                    "¡Error verificar usuario"
                            + "y contraseña sean válidas!");
        }

        /**
         * return new org.springframework.security.core.userdetails.User(
         * user.getEmail(),
         * user.getPassword(),
         * mapRoleToAuthority(user.getRol()));
         **/
        return new CustomUserDetails(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllByRoleId(Long id) {
        return userRepository.findByRolId(id);
    }

    @Override
    public void changePasswordByEmail(String email, String password) {
        this.userRepository.updatePasswordByEmail(email, password);
    }

    @Override
    public void signUpCourse(RegisterCourseDTO registerCourseDTO) {
        Applicant applicant = (Applicant) userRepository.findById(
                registerCourseDTO.getApplicantId()).orElseThrow();

        Course course = courseRepository.findById(
                registerCourseDTO.getCourseId()).orElseThrow();

        if (course.getAspirantLimit() > 0) {
            if (!(course.getApplicants().contains(applicant))) {
                course.setAspirantLimit(
                        (byte) (course.getAspirantLimit()
                                - 1));
            }

            applicant.getCourses().add(course);
            course.getApplicants().add(applicant);

            this.userRepository.save(applicant);
        }

    }

    @Override
    public Long getNewApplicants() {
        return userRepository.countTotalApplicantCourseRelations();
    }

    @Override
    public Boolean itIsRegistered(RegisterCourseDTO registerCourseDTO) {
        Applicant applicant = (Applicant) userRepository.findById(
                registerCourseDTO.getApplicantId()).orElseThrow();

        Course course = courseRepository.findById(
                registerCourseDTO.getCourseId()).orElseThrow();

        return applicant.getCourses().contains(course);

    }

    @Override
    public List<ApplicantInfoDTO> getAllApplicantInfoDTOs() {
        return userRepository.findAllApplicants().stream().map(
                applicantToApplicantInfoDTO::convertToDTO).collect(
                        Collectors.toList());
    }

    @Override
    public void deleteApplicantById(Long id) {
        userRepository.deleteById(id);
    }

    

}
