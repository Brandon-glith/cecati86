package net.javaguides.springboot.Models;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * @Entity
 * @Inheritance(strategy = InheritanceType.JOINED)
 * @Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
 **/

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Cambiar a SINGLE_TABLE
@DiscriminatorColumn(name = "user_type") // Se usa para distinguir las subclases
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private LocalDate creationDate;
    private LocalDate lastDateStartSession;
    @ManyToOne(fetch = FetchType.EAGER) // Relación con Rol
    @JoinColumn(name = "role_id", nullable = false) // Asegúrate de que 'role_id' es el nombre correcto
    private Rol rol; // Esto debe ser de tipo Rol, no Long

    public User() {

    }

    public User(
            String email,
            String password,
            Rol rol) {
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.creationDate = LocalDate.now();
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public LocalDate getLastDateStartSession() {
        return lastDateStartSession;
    }

    public void setLastDateStartSession(LocalDate lastDateStartSession) {
        this.lastDateStartSession = lastDateStartSession;
    }

}
