package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.DTO.RegisterCourseDTO;
import net.javaguides.springboot.Service.UserServiceImplementation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/sing-up-course")
public class ControllerSingUpCourse {

    @Autowired
    UserServiceImplementation userServiceImplementation;

    @PostMapping
    public String postMethodName(
            @RequestParam("applicantId") Long applicantId,
            @RequestParam("courseId") Long courseId) {

        RegisterCourseDTO registerCourseDTO = new RegisterCourseDTO();
        System.out.println("The applicant id: " + applicantId);
        System.out.println("The course id: " + courseId);

        registerCourseDTO.setApplicantId(applicantId);
        registerCourseDTO.setCourseId(courseId);

        userServiceImplementation.signUpCourse(registerCourseDTO);
        return "redirect:/registration";
    }

}
