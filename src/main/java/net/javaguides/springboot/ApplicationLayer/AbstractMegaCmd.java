package net.javaguides.springboot.ApplicationLayer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractMegaCmd {

    protected List<String> executableCommand() {
        return Arrays.asList(buildMegaCMDCommandComplete());
    }

    private String buildMegaCMDCommandComplete() {
        return "mega-" + getMegaCMDAction();
    }

    protected abstract String getMegaCMDAction();
}
