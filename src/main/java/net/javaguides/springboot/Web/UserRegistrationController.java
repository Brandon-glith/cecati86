package net.javaguides.springboot.Web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Service.EmailService;
import net.javaguides.springboot.Service.InterfaceUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private InterfaceUserService userService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpSession session;

    public UserRegistrationController(
            InterfaceUserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserRegistrationDTO registrationDTO,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Errores de validación: " + result.getAllErrors());
            return "registration";
        }

        String verificationCode = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(
                registrationDTO.getEmail(),
                verificationCode);

        session.setAttribute("user", registrationDTO);
        session.setAttribute("verificationCode", verificationCode);
        // userService.save(registrationDTO);

        return "redirect:/verification-code";
    }

}
