package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.Service.CourseService;
import net.javaguides.springboot.Service.NewsCategoryServiceImplementation;
import net.javaguides.springboot.Service.NewsServiceImplementation;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/upload-new")
public class NewController {

    @Autowired
    private NewsCategoryServiceImplementation categoryServiceImplementation;

    @Autowired
    NewsServiceImplementation newsServiceImplementation;

    @GetMapping
    public String getMethodName(Model model) {
        model.addAttribute("newsCategories", categoryServiceImplementation.getAllNewsCategoriesDTOs());
        model.getAttribute("newsCategories");
        return "upload-new";
    }

}
