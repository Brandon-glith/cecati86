package net.javaguides.springboot.ApplicationLayer;

import java.util.List;

public interface InterfaceMegaUtils {

    int executeComandMegaCMD(
        List<String> megaCMDComands) 
        throws java.io.IOException, 
        InterruptedException;

    void handleResult(
        int code, 
        AbstractMegaCmdRunner abstractMegaCmdRunner);
    String getProcessOutput();
}
