package net.javaguides.springboot.ApplicationLayer.Exceptions;

public class FileException extends Exception {

    public static final long serialVersionUID = 700l;

    public FileException(String message) {
        super(message);
    }
}
