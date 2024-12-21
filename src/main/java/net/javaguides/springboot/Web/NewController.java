package net.javaguides.springboot.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.DTO.NewsDTO;
import net.javaguides.springboot.Detail.CustomUserDetails;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Service.CourseService;
import net.javaguides.springboot.Service.NewsCategoryServiceImplementation;
import net.javaguides.springboot.Service.NewsServiceImplementation;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/upload-new")
public class NewController {

    @Autowired
    private NewsCategoryServiceImplementation categoryServiceImplementation;

    @Autowired
    NewsServiceImplementation newsServiceImplementation;

    @GetMapping
    public String getUploadNewsView(Model model) {
        model.addAttribute(
                "newsCategories",
                categoryServiceImplementation.getAllNewsCategoriesDTOs());
        model.addAttribute(
                "savedNews",
                newsServiceImplementation.getAllNewsDTOs());
        return "upload-new";
    }

    @ModelAttribute("news")
    public NewsDTO createNewsDTO() {
        return new NewsDTO();
    }

    @PostMapping
    public String uploadNews(
            @ModelAttribute("news") NewsDTO newsDTO,
            @RequestParam(value = "imagePath", required = false) String imagePath) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        newsDTO.setImageUrl(imagePath);
        newsDTO.setUser(userDetails.getUser());
        newsServiceImplementation.saveNews(newsDTO);
        return "redirect:/upload-new";
    }

    

}
