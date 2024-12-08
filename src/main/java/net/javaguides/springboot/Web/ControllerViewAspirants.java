package net.javaguides.springboot.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/views-aspirants")
public class ControllerViewAspirants {

    @GetMapping
    public String getView() {
        return "aspirants";
    }

}
