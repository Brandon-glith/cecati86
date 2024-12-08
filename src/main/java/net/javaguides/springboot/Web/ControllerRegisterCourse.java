package net.javaguides.springboot.Web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Service.CourseService;
import net.javaguides.springboot.Service.InterfaceCourseService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/register-course")
public class ControllerRegisterCourse {

    @Autowired
    InterfaceCourseService courseService;

    @GetMapping
    public String displayCourseHomePage() {
        return "register-course";
    }

    @ModelAttribute("course")
    public CourseDTO createCourseDTO() {
        return new CourseDTO();
    }

    @PostMapping
    public String registerCourse(
            @ModelAttribute("course") @Valid CourseDTO courseDTO, BindingResult result,
            @RequestParam(value = "imagePath", required = false) String imagePath) {

        if (result.hasErrors()) {
            System.out.println("Errores de validación: " + result.getAllErrors());
            return "register-course";
        }
        courseDTO.setImagePath(imagePath);
        courseService.save(courseDTO);
        return "register-course";
    }

}
