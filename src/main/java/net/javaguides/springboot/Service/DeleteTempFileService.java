package net.javaguides.springboot.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.ApplicationLayer.DeleteTempFileMessage;

@Service
public class DeleteTempFileService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enqueueTempFileDeletion(String fileDirectory) {
        DeleteTempFileMessage message = new DeleteTempFileMessage();
        message.setDirectoryName(fileDirectory);
        rabbitTemplate.convertAndSend("delete_temp_files", message);
        System.out.println("Temp file deletion request enqueued for: " + fileDirectory);
    }
}
