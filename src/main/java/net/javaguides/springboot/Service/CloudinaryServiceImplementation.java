package net.javaguides.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.cloudinary.utils.ObjectUtils;
import com.cloudinary.Cloudinary;
import java.util.Map;
import net.javaguides.springboot.ApplicationLayer.Exceptions.FileException;

@Service
public class CloudinaryServiceImplementation implements InterfaceCloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile file) throws FileException {
        System.out.println("The complete name is: " + file.getOriginalFilename());
        String fileUrl = "";
        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            fileUrl = uploadResult.get("url").toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return fileUrl;
    }

    @Override
    public Resource loadImage(String name) throws FileException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadImage'");
    }

}
