package net.javaguides.springboot.Service;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Detail.CustomUserDetails;
import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.Rol;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Repository.InterfaceRolRepository;
import net.javaguides.springboot.Repository.InterfaceUserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements InterfaceUserService {

    @Autowired
    private InterfaceUserRepository userRepository;
    @Autowired
    private InterfaceRolRepository rolRepository;
    @Autowired
    private BCryptPasswordEncoder eBCryptPasswordEncoder;

    @Override
    public Applicant save(UserRegistrationDTO registrationDTO) {
        Optional<Rol> optionalRol = rolRepository.findById(1L);

        // Verificamos si el Rol existe
        if (optionalRol.isPresent()) {
            Rol rol = optionalRol.get();

            // Creamos el usuario Applicant
            Applicant user = new Applicant(
                    registrationDTO.getEmail(),
                    eBCryptPasswordEncoder.encode(
                            registrationDTO.getPassword()),
                    rol);

            // Establecemos los atributos adicionales del Applicant
            user.setName(registrationDTO.getNames());
            user.setLastName(registrationDTO.getSurnames());
            user.setBirthdate(registrationDTO.getBirthdate());
            user.setPhoneNumber(registrationDTO.getPhoneNumber());

            // Guardamos el usuario en la base de datos y lo retornamos
            return userRepository.save(user);
        } else {
            // Si el Rol no se encuentra, puedes lanzar una excepción
            throw new RuntimeException("Rol no encontrado");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Applicant user = (Applicant) (userRepository.findByEmail(
                email));

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
    // User user = interfaceUserRepository.findByEmail(email);

}
