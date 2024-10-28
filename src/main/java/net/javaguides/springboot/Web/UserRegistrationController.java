package net.javaguides.springboot.Web;

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

    @GetMapping("verification")
    public String getMethodName(@RequestParam String param) {
        return "verification";
    }
    

    @PostMapping
    public String registerUserAccount(
            @ModelAttribute("user") @Valid UserRegistrationDTO registrationDTO,
            BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(registrationDTO);
        String verificationCode = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(
                registrationDTO.getEmail(),
                verificationCode);

        return "redirect:/registration?success";
    }

}
