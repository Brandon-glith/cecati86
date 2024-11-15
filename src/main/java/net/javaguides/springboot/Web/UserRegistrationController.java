package net.javaguides.springboot.Web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.ApplicationLayer.ValidationSequence;
import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Service.CourseService;
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

    @Autowired
    private CourseService courseService;

    public UserRegistrationController(
            InterfaceUserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("courses", courseService.getAllCourseDTOs());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(
            @ModelAttribute("user") @Validated(ValidationSequence.class) UserRegistrationDTO registrationDTO,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            System.out.println("Errores de validación: " + result.getAllErrors());
            return "registration";
        }

        if (registrationDTO.getPassword().equals(
                registrationDTO.getRepeatedPassword()) == false) {
            return "redirect:/registration?different";
        }

        String verificationCode = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(
                registrationDTO.getEmail(),
                verificationCode,
                "Tú codigo de verificación para creación de cuenta es: ");

        session.setAttribute("user", registrationDTO);
        session.setAttribute("verificationCode", verificationCode);
        session.setAttribute("action", "register");
        session.setAttribute("idRol", 1L);
        // userService.save(registrationDTO);

        return "redirect:/verification-code";
    }

}
