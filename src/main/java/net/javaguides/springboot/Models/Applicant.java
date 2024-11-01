package net.javaguides.springboot.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // Esta anotación es necesaria para las entidades
@DiscriminatorValue("APPLICANT") // Valor que se usará para distinguir Applicants en la tabla
public class Applicant extends User {
    @Column(name = "names")
    private String name;
    @Column(name = "surnames")
    private String lastName;
    @Column(name = "birthdate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Applicant() {
        super();
    }

    public Applicant(
            String email,
            String password,
            Rol rol) {
        super(email, password, rol);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

}
