package net.javaguides.springboot.ApplicationLayer;

public class CheckPassword implements InterfaceCheckPassword {

    @Override
    public boolean passwordAreEquals(
            String password,
            String repeatedPassword) {

        if (password.equals(repeatedPassword)) {
            return true;
        }

        return false;
    }

}
