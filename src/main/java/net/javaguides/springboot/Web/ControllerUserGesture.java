package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.Service.UserServiceImplementation;

@Controller
@RequestMapping("/gesture-user")
public class ControllerUserGesture {

    @Autowired
    private UserServiceImplementation serviceImplementation;

    @GetMapping
    public String getMethodName(Model model) {
        model.addAttribute(
                "applicantInfo",
                serviceImplementation.getAllApplicantInfoDTOs());
        return "gesture-user";
    }

    @DeleteMapping
    public String deleteApplicant(@RequestParam Long id) {
        serviceImplementation.deleteApplicantById(id);
        return "redirect:/gesture-user";
    }

}
