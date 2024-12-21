package net.javaguides.springboot.Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMINISTRATOR")
public class Administrator extends User {

}
