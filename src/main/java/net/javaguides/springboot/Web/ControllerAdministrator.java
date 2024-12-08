package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.Models.Course;
import net.javaguides.springboot.Service.CourseService;

@Controller
@RequestMapping("/view-admin")
public class ControllerAdministrator {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String getMethodName(Model model) {
        model.addAttribute("totalCourses",
                courseService.getTotalCourses());
        model.addAttribute(
                "courses",
                courseService.getAllCourseDTOs());
        return "admin-view";
    }

    @DeleteMapping("/delete-course{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/view-admin";
    }

}
