package net.javaguides.springboot.Service;

import java.util.List;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.Models.Course;

public interface InterfaceCourseService {

    List<CourseDTO> getAllCourseDTOs();

    void save(CourseDTO courseDTO);

    Long getTotalCourses();
}
