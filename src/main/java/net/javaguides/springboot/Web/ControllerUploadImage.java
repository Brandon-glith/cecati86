package net.javaguides.springboot.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.DTO.UserRegistrationDTO;
import net.javaguides.springboot.Service.CloudinaryServiceImplementation;
import net.javaguides.springboot.Service.CourseService;
import net.javaguides.springboot.Service.InterfaceCloudinaryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/upload-image")
public class ControllerUploadImage {

    @Autowired
    private CloudinaryServiceImplementation fileServiceImplementation;

    @PostMapping
    @ResponseBody // Esto permite devolver solo el contenido en lugar de una vista
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            System.out.println("Entered here");
            return fileServiceImplementation.uploadImage(file); // Devuelve solo la ruta del archivo como String
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al subir el archivo";
        }
    }
}
