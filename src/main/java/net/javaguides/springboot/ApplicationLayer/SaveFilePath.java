package net.javaguides.springboot.ApplicationLayer;

public class SaveFilePath {

    private static String pathFile;

    public static void setPathFile(String pathFile) {
        SaveFilePath.pathFile = pathFile;
    }

    public static String getPathFile() {
        return pathFile;
    }
}
