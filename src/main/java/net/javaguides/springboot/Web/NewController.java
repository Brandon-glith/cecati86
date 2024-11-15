package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.Service.CourseService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/upload-new")
public class NewController {

    @GetMapping
    public String getMethodName() {
        return "upload-new";
    }

}
