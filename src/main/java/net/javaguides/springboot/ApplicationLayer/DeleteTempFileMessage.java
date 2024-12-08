package net.javaguides.springboot.ApplicationLayer;

import java.io.Serializable;

public class DeleteTempFileMessage implements Serializable{

    private String directoryName;

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    
}
