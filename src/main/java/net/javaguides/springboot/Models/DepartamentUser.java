package net.javaguides.springboot.Models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity // Esta anotación es necesaria para las entidades
@DiscriminatorValue("DEPARTAMENTO")
public class DepartamentUser extends User {

}
