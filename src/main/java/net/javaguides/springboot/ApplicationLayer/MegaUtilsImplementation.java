package net.javaguides.springboot.ApplicationLayer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Optional;

public class MegaUtilsImplementation implements InterfaceMegaUtils {
    private String processOutput;

    private final Object lock = new Object();

    @Override
    public int executeComandMegaCMD(List<String> megaCMDComands)
            throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(megaCMDComands);
        Process process = processBuilder.start();
        Boolean succeeded = process.waitFor(30000, TimeUnit.MILLISECONDS);
        processOutput = new String(
                process.getInputStream().readAllBytes(),
                StandardCharsets.UTF_8);
        System.out.println("The output is: " + getProcessOutput());

        return succeeded ? process.exitValue() : -1;

    }

    @Override
    public void handleResult(
            int code,
            AbstractMegaCmdRunner abstractMegaCmdRunner) {
        int posixExitStatus = Optional.ofNullable(code)
                .map(Math::abs)
                .orElse(-1);

        MegaCMDExport cMDExport = null;

        if (abstractMegaCmdRunner instanceof MegaCMDExport
                && posixExitStatus == 63) {
            cMDExport = (MegaCMDExport) abstractMegaCmdRunner;

            cMDExport.isAlreadyExported().run();
        }

        if (abstractMegaCmdRunner instanceof MegaCMDExport
                && posixExitStatus == 0) {
            cMDExport = (MegaCMDExport) abstractMegaCmdRunner;

            if (cMDExport.isIsAlreadyExported()) {
                cMDExport.isDisabledExport().run();
            }
        }
    }

    @Override
    public String getProcessOutput() {
        return processOutput;
    }

}
