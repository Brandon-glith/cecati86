package net.javaguides.springboot.Web;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.ApplicationLayer.GetNewAspirants;
import net.javaguides.springboot.Models.Course;
import net.javaguides.springboot.Repository.InterfaceCourseRepository;
import net.javaguides.springboot.Service.CourseService;
import net.javaguides.springboot.Service.UserServiceImplementation;

@Controller
@RequestMapping("/view-departament")
public class ControllerDepartament {

        @Autowired
        private CourseService courseService;

        @Autowired
        private UserServiceImplementation serviceImplementation;

        private GetNewAspirants getNewAspirants = new GetNewAspirants();

        private Integer currentApplicants;

        @Autowired
        HttpSession httpSession;

        @GetMapping
        public String getMethodName(Model model) {

                model.addAttribute("totalCourses",
                                courseService.getTotalCourses());
                model.addAttribute(
                                "courses",
                                courseService.getAllCourseDTOs());
                model.addAttribute(
                                "newApplicants",
                                serviceImplementation.getNewApplicants());
                httpSession.setAttribute(
                                "newApplicants",
                                serviceImplementation.getNewApplicants());

                return "admin-control-E-V";
        }

        @DeleteMapping("/delete-course{id}")
        public String deleteCourse(@PathVariable Long id) {
                courseService.deleteCourse(id);
                return "redirect:/view-departament";
        }

}
