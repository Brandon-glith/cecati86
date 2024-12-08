package net.javaguides.springboot.Service;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.javaguides.springboot.ApplicationLayer.CreateTempFile;
import net.javaguides.springboot.ApplicationLayer.DeleteTempFile;
import net.javaguides.springboot.ApplicationLayer.DeleteTempFileMessage;
import net.javaguides.springboot.ApplicationLayer.FileOperationMessage;
import net.javaguides.springboot.ApplicationLayer.MegaCMDPut;
import net.javaguides.springboot.ApplicationLayer.MegaSDK;

@Service
public class MegaServiceImplementation implements InterfaceMegaService {

    @Autowired
    private MegaSDK megaSDK;
    private CreateTempFile createTempFile = new CreateTempFile();
    // private DeleteTempFile deleteTempFile = new DeleteTempFile();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    @Autowired
    private FileUploadService fileUploadService;
    //
    @Autowired
    DeleteTempFileService deleteTempFileService;

    @Override
    public void createDirectory(String directoryName) {
        megaSDK.createDirectory(directoryName);
    }

    @Override
    public void uploadFile(FileOperationMessage fileOperationMessage) {
        
        executor.submit(() -> {
            fileUploadService.moveFileToTempDirectory(fileOperationMessage);
        });

    }

}
