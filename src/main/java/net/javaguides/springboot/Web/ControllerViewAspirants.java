package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.Service.UserServiceImplementation;

@Controller
@RequestMapping("/views-aspirants")
public class ControllerViewAspirants {

    @Autowired
    private UserServiceImplementation serviceImplementation;

    @GetMapping
    public String getView(Model model) {
        //System.out.println(serviceImplementation.getAllApplicantInfoDTOs().get(0));
        model.addAttribute(
                "applicantInfo",
                serviceImplementation.getAllApplicantInfoDTOs());
        return "aspirants";
    }

}
