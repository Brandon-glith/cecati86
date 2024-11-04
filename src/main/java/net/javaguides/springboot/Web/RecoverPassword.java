package net.javaguides.springboot.Web;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.Service.EmailService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/recover-password")
public class RecoverPassword {

    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpSession session;

    @GetMapping("/request")
    public String getMethodName(@RequestParam("email") String email, Model model) {
        model.addAttribute("email", email);
        String generatedCode = emailService.generateVerificationCode();
        emailService.sendVerificationEmail(
                email,
                generatedCode,
                "Tú código de verificación"
                        + " para cambiar contraseña es: ");
        session.setAttribute(
                "email",
                model.getAttribute("email"));
        session.setAttribute("verificationCode", generatedCode);
        session.setAttribute("action", "changePassword");
        return "redirect:/verification-code";
    }

    @PostMapping
    public String processRecoverPasswordRequest(@RequestParam("name") String name,
            @RequestParam("phone") String phone) {

        System.out.println("Received recovery request: Name: " + name + ", Phone: " + phone);

        // Replace with your desired action after processing (e.g., redirect to success
        // page)
        return "redirect:/verification-code"; // Replace with your success view name
    }

}
