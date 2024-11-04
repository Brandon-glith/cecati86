package net.javaguides.springboot.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.Models.Course;
import net.javaguides.springboot.Repository.InterfaceCourseRepository;

@Service
public class CourseService {

    @Autowired
    private InterfaceCourseRepository courseRepository;

    public List<CourseDTO> getAllCourseDTOs() {
        return courseRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private CourseDTO convertToDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setCourseName(course.getCourseName());
        dto.setDescription(course.getDescription());
        dto.setDurationHours(course.getDurationHours());
        dto.setStartDate(course.getStartDate());
        dto.setEndDate(course.getEndDate());
        dto.setCost(course.getCost());
        dto.setCourseType(course.getCourseType());
        dto.setImagePath(course.getImagePath());
        return dto;
    }
}
