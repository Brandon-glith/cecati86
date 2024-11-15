package net.javaguides.springboot.Service;

import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.ApplicationLayer.Exceptions.FileException;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface InterfaceCloudinaryService {

    String uploadImage(MultipartFile file) throws FileException;

    public Resource loadImage(String name) throws FileException;
}
