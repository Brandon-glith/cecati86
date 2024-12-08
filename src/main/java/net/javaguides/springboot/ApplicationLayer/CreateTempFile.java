package net.javaguides.springboot.ApplicationLayer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.springframework.web.multipart.MultipartFile;

public class CreateTempFile {

        private File file = new File("");

        public String processMessage(FileOperationMessage message) {
                String completePath = this.file
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

                return tempFile.toAbsolutePath().toString();
        }
}
