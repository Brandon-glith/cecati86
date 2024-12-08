package net.javaguides.springboot.ApplicationLayer;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileOperationMessage implements Serializable {

    private byte[] fileData;
    private String userName;
    private String fileName;
    private String fileNameFromList;

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameFromList() {
        return fileNameFromList;
    }

    public void setFileNameFromList(String fileNameFromList) {
        this.fileNameFromList = fileNameFromList;
    }

}
