package net.javaguides.springboot.Web;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.ApplicationLayer.CreateTempFile;
import net.javaguides.springboot.ApplicationLayer.DeleteTempFile;
import net.javaguides.springboot.ApplicationLayer.FileOperationMessage;
import net.javaguides.springboot.ApplicationLayer.RequiredDocuments;
import net.javaguides.springboot.Detail.CustomUserDetails;
import net.javaguides.springboot.Models.Applicant;
import net.javaguides.springboot.Models.User;
import net.javaguides.springboot.Repository.InterfaceUserRepository;
import net.javaguides.springboot.Service.CourseService;
import net.javaguides.springboot.Service.FileOperationConsumer;
import net.javaguides.springboot.Service.FileUploadProducer;
import net.javaguides.springboot.Service.FileUploadService;
import net.javaguides.springboot.Service.MegaServiceImplementation;

@Controller
@RequestMapping("/upload-documentation")
public class ControllerUploadDocumentation {

        @Autowired
        private MegaServiceImplementation megaServiceImplementation;

        @Autowired
        private HttpSession session;

        private Long courseId;

        private String courseName;

        @Autowired
        InterfaceUserRepository interfaceUserRepository;

        @Autowired
        private FileUploadProducer fileUploadProducer;

        @GetMapping
        public String getView(
                        @RequestParam("courseId") Long courseId,
                        @RequestParam("courseName") String courseName,
                        Model model) {
                session.setAttribute("courseId", courseId);
                session.setAttribute("courseName", courseName);
                Authentication authentication = SecurityContextHolder
                                .getContext()
                                .getAuthentication();
                CustomUserDetails userDetails = (CustomUserDetails) authentication
                                .getPrincipal();
                User user = userDetails.getUser();

                if (interfaceUserRepository.existsByIdNative(
                                user.getId()) == 1) {

                        return "redirect:/registration?invalid";
                }

                megaServiceImplementation.createDirectory(courseName);
                megaServiceImplementation.createDirectory(courseName + "/" +
                                user.getName()
                                + " " + user.getLastName());
                model.addAttribute("courseId", courseId);
                model.addAttribute("applicantId", user.getId());
                model.addAttribute("courseName", courseName);
                return "upload-documentation";
        }

        @PostMapping
        public String postMethodName(@RequestParam("file") MultipartFile file,
                        @RequestParam("index") Integer index, Model model) {
                Authentication authentication = SecurityContextHolder
                                .getContext()
                                .getAuthentication();
                CustomUserDetails userDetails = (CustomUserDetails) authentication
                                .getPrincipal();
                User user = userDetails.getUser();

                System.out.println("The actual index is: " + index);
                courseId = (Long) session.getAttribute("courseId");
                this.courseName = (String) session.getAttribute("courseName");
                System.out.println("The course name is: " + courseName);
                System.out.println(
                                user.getName()
                                                + " " + user.getId()
                                                + "\n"
                                                + file.getOriginalFilename()
                                                + " " + (file.getSize() / 1024));
                String nameDirectory = courseName
                                + "/" + user.getName() + " " + user.getLastName();
                FileOperationMessage fileOperationMessage = new FileOperationMessage();

                try {
                        byte[] fileData = file.getBytes();
                        fileOperationMessage.setFileData(fileData);
                } catch (IOException e) {
                        // Handle the exception appropriately, e.g., log the error, return an error
                        // message, or retry the operation
                        e.printStackTrace();
                        // Consider adding more specific error handling based on your application's
                        // requirements
                }

                fileOperationMessage.setUserName(
                                user.getName()
                                                + " "
                                                + user.getLastName());
                fileOperationMessage.setFileNameFromList(
                                RequiredDocuments.getNameDocument(index)
                                                + "_" + user.getId());
                fileOperationMessage.setFileName(nameDirectory);

                this.megaServiceImplementation.uploadFile(
                                fileOperationMessage);

                String encodedCourseName = "";

                try {
                        encodedCourseName = URLEncoder.encode(courseName, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                        e.printStackTrace(); // Manejar el error de codificación si es necesario
                }

                return "redirect:/upload-documentation?courseId="
                                + courseId + "&courseName=" + encodedCourseName;

        }

}
