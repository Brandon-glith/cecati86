package net.javaguides.springboot.Presenters;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.Models.Course;

@Component
public class CourseDTOToCourseMapper implements InterfaceDTOToEntityMapper<CourseDTO, Course> {

    @Override
    public Course convertToEntity(CourseDTO courseDTO) {
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
        return course;
    }

}
