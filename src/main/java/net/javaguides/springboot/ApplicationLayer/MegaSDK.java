package net.javaguides.springboot.ApplicationLayer;

public class MegaSDK {

    private String email;
    private String password;

    public MegaSDK(String email, String password) {
        this.email = email;
        this.password = password;
        login();
    }

    private void login() {
        MegaCmdLogin cmdLogin = new MegaCmdLogin(
                email,
                password);
        cmdLogin.run();
    }

    public void createDirectory(String directoryName) {
        MegaCMDMkdir megaCMDMkdir = new MegaCMDMkdir(
                directoryName);
        megaCMDMkdir.run();
    }

}
