package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Models.News;

public interface InterfaceNewsRepository extends JpaRepository<News, Long> {

}
