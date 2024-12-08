package net.javaguides.springboot.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.ApplicationLayer.FileOperationMessage;
import net.javaguides.springboot.ApplicationLayer.SaveFilePath;

@Service
public class FileUploadService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Object lock = new Object();

    public void moveFileToTempDirectory(
            FileOperationMessage message) {
        synchronized (lock) {
            rabbitTemplate.convertAndSend("file_operations", message);
        }

    }
}
