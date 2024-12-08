package net.javaguides.springboot.ApplicationLayer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MegaCMDExport extends AbstractMegaCmdRunnerWithParams {
    List<String> cmdParams;
    private Optional<String> remotePath;
    private boolean isAlreadyExported;

    public MegaCMDExport(String userDirectory,
            String fileName) {

        this.remotePath = Optional.of(
                userDirectory
                        + "/"
                        + fileName);

        this.isAlreadyExported = false;
    }

    @Override
    List<String> cmdParams() {
        this.cmdParams = new LinkedList<String>();
        this.remotePath.ifPresent(modify -> {
            this.cmdParams.add(
                    this.isIsAlreadyExported() ? "-d" : "-a");

        });

        this.remotePath.ifPresent(cmdParams::add);
        return cmdParams;
    }

    @Override
    protected String getMegaCMDAction() {
        return "export";
    }

    public MegaCMDExport isAlreadyExported() {
        this.isAlreadyExported = true;
        return this;
    }

    public MegaCMDExport isDisabledExport() {
        this.isAlreadyExported = false;
        return this;
    }

    public boolean isIsAlreadyExported() {
        return isAlreadyExported;
    }

}
