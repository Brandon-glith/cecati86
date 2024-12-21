package net.javaguides.springboot.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.DTO.NewsDTO;
import net.javaguides.springboot.Models.InterfaceNews;
import net.javaguides.springboot.Repository.InterfaceNewsRepository;
import net.javaguides.springboot.Service.NewsServiceImplementation;

@Controller
@RequestMapping("/delete-new")
public class ControllerDeleteNew {

    @Autowired
    NewsServiceImplementation implementation;

    @Autowired
    InterfaceNewsRepository interfaceNewsRepository;

    @PostMapping
    public String deleteNews(@RequestParam("index") Integer index, Model model) {
        List<NewsDTO> news = (List<NewsDTO>) implementation.getAllNewsDTOs();

        NewsDTO newsDTO = news.get(index);

        interfaceNewsRepository.deleteById(
                newsDTO.getId());
        return "redirect:/upload-new";
    }
}
