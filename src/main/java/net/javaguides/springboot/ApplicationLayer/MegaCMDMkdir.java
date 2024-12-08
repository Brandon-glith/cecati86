package net.javaguides.springboot.ApplicationLayer;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

public class MegaCMDMkdir extends AbstractMegaCmdRunnerWithParams {

    private List<String> cmdParams;

    public MegaCMDMkdir(String nameFolder) {
        cmdParams = Arrays.asList(nameFolder);

    }

    @Override
    List<String> cmdParams() {
        return cmdParams;
    }

    @Override
    protected String getMegaCMDAction() {
        return "mkdir";
    }

}
