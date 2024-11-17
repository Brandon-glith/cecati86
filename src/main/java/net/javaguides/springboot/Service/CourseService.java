package net.javaguides.springboot.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTO.CourseDTO;
import net.javaguides.springboot.Models.Course;
import net.javaguides.springboot.Presenters.CourseDTOToCourseMapper;
import net.javaguides.springboot.Presenters.CourseToCourseDTOMapper;
import net.javaguides.springboot.Presenters.CourseToCourseDTOMapper;
import net.javaguides.springboot.Repository.InterfaceCourseRepository;

@Service
public class CourseService implements InterfaceCourseService {

    @Autowired
    private InterfaceCourseRepository courseRepository;

    @Autowired
    private CourseToCourseDTOMapper courseMapper;

    @Autowired
    private CourseDTOToCourseMapper courseDTOToCourseMapper;

    @Override
    public List<CourseDTO> getAllCourseDTOs() {
        return courseRepository.findAll().stream().map(courseMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void save(CourseDTO courseDTO) {
        try {
            courseRepository.save(courseDTOToCourseMapper.convertToEntity(courseDTO));   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getTotalCourses() {
        return courseRepository.count();
    }
}
