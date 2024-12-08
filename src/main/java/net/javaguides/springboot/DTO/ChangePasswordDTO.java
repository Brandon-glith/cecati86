package net.javaguides.springboot.DTO;

import net.javaguides.springboot.ApplicationLayer.BasicValidationGroup;
import net.javaguides.springboot.ApplicationLayer.ValidPassword;

public class ChangePasswordDTO {

    @ValidPassword(groups = BasicValidationGroup.class)
    private String password;
    @ValidPassword(groups = BasicValidationGroup.class)
    private String repeatedPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

}
