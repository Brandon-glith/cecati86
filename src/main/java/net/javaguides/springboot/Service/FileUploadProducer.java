package net.javaguides.springboot.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFileUploadMessage(String userId, String filePath) {

    }
}
