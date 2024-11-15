package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Service.InterfaceUserService;
import net.javaguides.springboot.Service.UserServiceImplementation;

@RestController
@RequestMapping("/test/users")
public class TestController {
    @Autowired
    private InterfaceUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
            @RequestBody UserRegistrationDTO registrationDTO,
            @RequestParam(name = "role_id") Long rolId) {
        try {
            User newUser = userService.save(registrationDTO, rolId);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
