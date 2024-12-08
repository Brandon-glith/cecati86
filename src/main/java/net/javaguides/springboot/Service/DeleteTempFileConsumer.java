package net.javaguides.springboot.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.ApplicationLayer.DeleteTempFileMessage;

@Component
public class DeleteTempFileConsumer {

    //@RabbitListener(queues = "delete_temp_files")
    public void consumeDeleteTempFileMessage(DeleteTempFileMessage message) {
        String fileDirectory = message.getDirectoryName();
        try {
            Files.deleteIfExists(Paths.get(fileDirectory));
            System.out.println("Deleted temp file: " + fileDirectory);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle deletion failure, e.g., log the error
        }
    }
}
