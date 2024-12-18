package net.javaguides.springboot.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.ApplicationLayer.DeleteTempFile;
import net.javaguides.springboot.ApplicationLayer.FileOperationMessage;
import net.javaguides.springboot.ApplicationLayer.MegaCMDPut;
import net.javaguides.springboot.ApplicationLayer.SaveFilePath;

@Component
public class FileOperationConsumer {

    @RabbitListener(queues = "file_operations")
    public  void processMessage(FileOperationMessage message) {
        File file = new File("");
        String completeFilePath = "";
        System.out.println(message.getUserName());

        String completePath = file
                .getAbsolutePath() + "/"
                + message.getUserName();

        Path tempDir = Paths.get(completePath);

        try {

            if (!Files.exists(tempDir)) {
                Files.createDirectories(tempDir);
                System.out.println(
                        "Directorio temporal creado en: " + tempDir.toAbsolutePath());

            }
        } catch (Exception e) {
            System.out.println("No se pudo crear el directorio temporal.");
            e.printStackTrace();
        }

        Path tempFile = tempDir.resolve(
                message.getFileNameFromList() + ".pdf");

        try {

            Files.write(
                    tempFile,
                    message.getFileData());
            System.out.println("Temp file created satisfactorily!");

        } catch (Exception e) {
            System.out.println("File was not possible move to file path!");
            e.printStackTrace();
        }

        String path = tempFile.toAbsolutePath().toString();
        MegaCMDPut cmdPut = new MegaCMDPut(
                path, message.getFileName());
        cmdPut.run();

        DeleteTempFile deleteTempFile = new DeleteTempFile();
        deleteTempFile.deleteTempFile(path);

    }

}
