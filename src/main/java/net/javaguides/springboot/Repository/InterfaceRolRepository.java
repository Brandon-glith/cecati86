package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Models.Rol;
import net.javaguides.springboot.Models.User;

public interface InterfaceRolRepository extends JpaRepository<Rol, Long>{

}
