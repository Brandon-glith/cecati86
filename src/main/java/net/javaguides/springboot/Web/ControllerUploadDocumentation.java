package net.javaguides.springboot.Web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/upload-documentation")
public class ControllerUploadDocumentation {

    @GetMapping
    public String getView() {
        return "upload-documentation";
    }

    

}
