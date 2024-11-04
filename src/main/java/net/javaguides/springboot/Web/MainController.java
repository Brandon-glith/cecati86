package net.javaguides.springboot.Web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.ApplicationLayer.EmailDuplicateChecker;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Service.UserServiceImplementation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    @Autowired
    UserServiceImplementation implementation;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping
    public String home() {
        return "redirect:/registration";
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkDuplicateEmail(@RequestParam("email") String email) {
        User user = implementation.findByEmail(email);

        if (user != null) {
            return ResponseEntity.ok(false);
        }
        // Si no existe el usuario, devolver true (correo no existente)
        return ResponseEntity.ok(true);
    }

   

}
