package net.javaguides.springboot.Presenters;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.Models.Course;

@Component
public class CourseToCourseDTOMapper implements InterfaceEntityToDTOMapper<CourseDTO, Course> {

    // CourseToCourseDTOMapper
    // CourseDTOToCourse

    @Override
    public CourseDTO convertToDTO(Course course) {
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
        dto.setId(course.getId());
        dto.setApplicants(course.getApplicants());
        return dto;
    }

}
