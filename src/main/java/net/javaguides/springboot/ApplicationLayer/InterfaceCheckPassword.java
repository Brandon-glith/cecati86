package net.javaguides.springboot.ApplicationLayer;

public interface InterfaceCheckPassword {

    boolean passwordAreEquals(
            String password,
            String repeatedPassword);
}
