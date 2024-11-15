package net.javaguides.springboot.Web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.ApplicationLayer.BasicValidationGroup;
import net.javaguides.springboot.ApplicationLayer.ValidationSequence;
import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Service.CourseService;
import net.javaguides.springboot.Service.EmailService;
import net.javaguides.springboot.Service.InterfaceUserService;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/managment-user")
public class UserManagementController {

    @Autowired
    private InterfaceUserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpSession session;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String getViewManagment() {
        return "user-managment";
    }

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @PostMapping
    public String registerUserAccount(
            @ModelAttribute("user") @Validated(BasicValidationGroup.class) UserRegistrationDTO registrationDTO,
            BindingResult result, @RequestParam("role") Long role,
            Model model) {

        if (result.hasErrors()) {
            System.out.println("Errors: " + result.getAllErrors());
            return "user-managment";
        }
        String verificationCode = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(
                registrationDTO.getEmail(),
                verificationCode,
                "Tú codigo de verificación para creación de cuenta es: ");

        session.setAttribute("user", registrationDTO);
        session.setAttribute("verificationCode", verificationCode);
        session.setAttribute("action", "register");
        session.setAttribute("idRol", role);
        // userService.save(registrationDTO);

        return "redirect:/verification-code";
    }

}
