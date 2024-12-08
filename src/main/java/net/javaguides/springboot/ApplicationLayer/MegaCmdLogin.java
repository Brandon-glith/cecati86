package net.javaguides.springboot.ApplicationLayer;

import java.util.Arrays;
import java.util.List;

public class MegaCmdLogin extends AbstractMegaCmdRunnerWithParams {
    private List<String> cmdParams;

    public MegaCmdLogin(String email, String password) {
        cmdParams = Arrays.asList(
                email,
                password);
    }

    @Override
    List<String> cmdParams() {
        return cmdParams;
    }

    @Override
    protected String getMegaCMDAction() {
        return "login";
    }

}
