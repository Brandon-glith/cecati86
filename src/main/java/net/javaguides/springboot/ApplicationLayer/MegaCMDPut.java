package net.javaguides.springboot.ApplicationLayer;

import java.util.List;
import java.util.Arrays;
import java.util.List;

public class MegaCMDPut extends AbstractMegaCmdRunnerWithParams {

    private List<String> cmdParams;

    public MegaCMDPut(String localFilePath, String megaDirectoryPath) {
        this.cmdParams = Arrays.asList(
                localFilePath,
                megaDirectoryPath);
    }

    @Override
    List<String> cmdParams() {
        return cmdParams;
    }

    @Override
    protected String getMegaCMDAction() {
        return "put";
    }

}
