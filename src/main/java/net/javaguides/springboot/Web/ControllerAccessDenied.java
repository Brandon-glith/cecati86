package net.javaguides.springboot.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/error-403")
public class ControllerAccessDenied {

    @GetMapping
    public String getMethodName() {
        return "access-error";
    }

}
