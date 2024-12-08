package net.javaguides.springboot.Web;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.ApplicationLayer.BasicValidationGroup;
import net.javaguides.springboot.ApplicationLayer.CheckPassword;
import net.javaguides.springboot.ApplicationLayer.ValidationSequence;
import net.javaguides.springboot.DTO.ChangePasswordDTO;
import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Service.UserServiceImplementation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/change-password")
public class ControllerChangePasswordView {

    private String email;
    private CheckPassword checkPassword = new CheckPassword();

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @Autowired
    private BCryptPasswordEncoder eBCryptPasswordEncoder;

    @ModelAttribute("changePassword")
    public ChangePasswordDTO changePasswordDTO() {
        return new ChangePasswordDTO();
    }

    @GetMapping
    public String getMethodName(Model model, HttpSession httpSession) {
        this.email = (String) (httpSession.getAttribute("email"));
        return "change-password";
    }

    @PostMapping
    public String postMethodName(
            @ModelAttribute("changePassword") @Valid ChangePasswordDTO changePasswordDTO,
            BindingResult result,
            Model model) {

        email = (String) (httpSession.getAttribute("email"));

        if (result.hasErrors()) {
            System.out.println("Errores de validación: " + result.getAllErrors());
            return "change-password";
        }

        System.out.println(
                "Password : "
                        + changePasswordDTO.getPassword()
                        + " Password_2: " + changePasswordDTO.getRepeatedPassword());
        if (checkPassword.passwordAreEquals(
                changePasswordDTO.getPassword(),
                changePasswordDTO.getRepeatedPassword())) {

            userServiceImplementation.changePasswordByEmail(
                    email,
                    eBCryptPasswordEncoder.encode(
                            changePasswordDTO.getPassword()));

        } else {
            return "redirect:/change-password?different";
        }

        return "redirect:/registration";
    }

}
