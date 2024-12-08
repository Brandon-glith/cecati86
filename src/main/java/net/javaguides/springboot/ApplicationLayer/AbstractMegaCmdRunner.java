package net.javaguides.springboot.ApplicationLayer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractMegaCmdRunner extends AbstractMegaCmd implements Runnable {

    @Override
    public void run() {
        executeSysCmd(executableCommand());
    }

    protected void executeSysCmd(List<String> megaCMDComands) {
        try {
            MegaUtilsImplementation result = new MegaUtilsImplementation();
            int saveResult = result.executeComandMegaCMD(
                    megaCMDComands);
            System.out.println("The result comand is: " + saveResult);
            result.handleResult(saveResult, this);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
