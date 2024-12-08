package net.javaguides.springboot.ApplicationLayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeleteTempFile {

    private final Lock lock = new ReentrantLock();

    public boolean deleteTempFile(String fileDirectory) {

        Path path = Paths.get(fileDirectory);

        if (Files.exists(path)) {
            lock.lock();
            try {

                Files.delete(path);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        return false;

    }
}
