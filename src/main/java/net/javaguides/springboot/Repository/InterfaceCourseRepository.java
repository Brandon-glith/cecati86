package net.javaguides.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.Models.Course;

public interface InterfaceCourseRepository extends JpaRepository<Course, Long> {

}
