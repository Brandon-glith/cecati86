package net.javaguides.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.Models.Course;

public interface InterfaceCourseRepository extends JpaRepository<Course, Long> {

}
