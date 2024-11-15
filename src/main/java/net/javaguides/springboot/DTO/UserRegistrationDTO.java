package net.javaguides.springboot.DTO;

import java.time.LocalDate;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import net.javaguides.springboot.ApplicationLayer.AdvancedValidationGroup;
import net.javaguides.springboot.ApplicationLayer.BasicValidationGroup;
import net.javaguides.springboot.ApplicationLayer.UniqueEmail;
import net.javaguides.springboot.ApplicationLayer.ValidAge;
import net.javaguides.springboot.ApplicationLayer.ValidEmail;
//import net.javaguides.springboot.ApplicationLayer.ValidEmail;
import net.javaguides.springboot.ApplicationLayer.ValidName;
import net.javaguides.springboot.ApplicationLayer.ValidPassword;
import net.javaguides.springboot.ApplicationLayer.ValidPhone;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRegistrationDTO {
    @NotEmpty(message = "Names are required", groups = BasicValidationGroup.class)
    @ValidName(groups = BasicValidationGroup.class)
    private String names;
    @NotEmpty(message = "Surnames are required", groups = BasicValidationGroup.class)
    @ValidName(message = "Inserte apellidos validos", groups = BasicValidationGroup.class)
    private String surnames;

    @NotEmpty(message = "Email is required", groups = BasicValidationGroup.class)
    @ValidEmail(groups = BasicValidationGroup.class)
    @UniqueEmail(groups = BasicValidationGroup.class)
    private String email;
    @ValidPassword(groups = BasicValidationGroup.class)
    private String password;
    @ValidPassword(groups = BasicValidationGroup.class)
    private String repeatedPassword;

    @ValidAge(message = "¡Debes tener por lo menos 15 años para causar registro!", groups = AdvancedValidationGroup.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
    @ValidPhone(groups = AdvancedValidationGroup.class)
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid", groups = AdvancedValidationGroup.class)
    private String phoneNumber;

    public UserRegistrationDTO() {

    }

    public UserRegistrationDTO(
            String names,
            String surnames,
            String email,
            String password,
            String repeatedPassword,
            LocalDate birthdate,
            String phoneNumber) {
        this.names = names;
        this.surnames = surnames;
        this.email = email;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

}
