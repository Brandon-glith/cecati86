package net.javaguides.springboot.Service;

import javax.mail.Multipart;

import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.ApplicationLayer.FileOperationMessage;

public interface InterfaceMegaService {

    void createDirectory(String directoryName);

    void uploadFile(
            FileOperationMessage fileOperationMessage);
}
