package net.javaguides.springboot.Web;

import java.time.LocalDate;
import java.time.Period;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Service.EmailService;
import net.javaguides.springboot.Service.InterfaceUserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/verification-code")
@SessionAttributes({ "user", "verificationCode" })
public class VerificationController {

        @Autowired
        private EmailService emailService;

        @Autowired
        private InterfaceUserService userService;

        @GetMapping
        public String showVerificationForm(
                        Model model,
                        HttpSession session) {
                UserRegistrationDTO user = (UserRegistrationDTO) session.getAttribute(
                                "user");
                String verificationCode = (String) session.getAttribute(
                                "verificationCode");
                String action = (String) session.getAttribute(
                                "action");
                String email = (String) session.getAttribute("email");
                model.addAttribute(
                                "user",
                                user);
                model.addAttribute(
                                "verificationCode",
                                verificationCode);

                model.addAttribute("action", action);
                model.addAttribute("email", email);
                return "verification";
        }

        @PostMapping
        public String verifyCode(

                        @RequestParam("digit1") String digit1,
                        @RequestParam("digit2") String digit2,
                        @RequestParam("digit3") String digit3,
                        @RequestParam("digit4") String digit4,
                        @RequestParam("digit5") String digit5,
                        @RequestParam("digit6") String digit6,
                        Model model, HttpSession session) {

                String fullCode = digit1 + digit2 + digit3 + digit4 + digit5 + digit6;

                UserRegistrationDTO user = (UserRegistrationDTO) session.getAttribute(
                                "user");
                String verificationCode = (String) session.getAttribute(
                                "verificationCode");
                String action = (String) session.getAttribute(
                                "action");
                String email = (String) session.getAttribute("email");
                Long idRol = (Long) session.getAttribute("idRol");
                model.addAttribute(
                                "user",
                                user);
                model.addAttribute(
                                "verificationCode",
                                verificationCode);

                model.addAttribute("action", action);
                model.addAttribute("email", email);

                String storedVerificationCode = (String) model.getAttribute(
                                "verificationCode");
                action = (String) model.getAttribute("action");
                email = (String) model.getAttribute("email");

                System.out.println("The action is: " + action);
                if (!fullCode.equals(storedVerificationCode)) {
                        return "redirect:/verification-code?invalid";
                }

                switch (action) {
                        case "register":
                                UserRegistrationDTO registrationDTO = (UserRegistrationDTO) model.getAttribute(
                                                "user");
                                userService.save(registrationDTO, idRol);
                                return "redirect:/registration?success";
                        case "changePassword":

                                break;
                        default:
                                break;
                }

                return "redirect:/verification-code?error";
        }

}
