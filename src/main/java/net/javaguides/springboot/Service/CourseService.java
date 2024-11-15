package net.javaguides.springboot.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.Models.Course;
import net.javaguides.springboot.Repository.InterfaceCourseRepository;

@Service
public class CourseService implements InterfaceCourseService {

    @Autowired
    private InterfaceCourseRepository courseRepository;

    @Override
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
        dto.setAspirantLimit(course.getAspirantLimit());
        return dto;
    }

    @Override
    public void save(CourseDTO courseDTO) {
        System.out.println("Entered here!");
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setDescription(courseDTO.getDescription());
        course.setDurationHours(courseDTO.getDurationHours());
        course.setStartDate(courseDTO.getStartDate());
        course.setEndDate(courseDTO.getEndDate());
        course.setCost(courseDTO.getCost());
        course.setCourseType(courseDTO.getCourseType());
        course.setImagePath(courseDTO.getImagePath());
        course.setAspirantLimit(courseDTO.getAspirantLimit());

        courseRepository.save(course);
    }

    @Override
    public Long getTotalCourses() {
        return courseRepository.count();
    }
}
