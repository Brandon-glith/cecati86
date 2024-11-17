package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Models.NewsCategory;

public interface InterfaceNewsCategoryRepository extends JpaRepository<NewsCategory, Long> {

}
