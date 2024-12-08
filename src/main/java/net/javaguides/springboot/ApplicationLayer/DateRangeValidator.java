package net.javaguides.springboot.ApplicationLayer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import net.javaguides.springboot.DTO.CourseDTO;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, CourseDTO> {

    @Override
    public boolean isValid(CourseDTO courseDTO, ConstraintValidatorContext context) {
        if (courseDTO.getStartDate() == null || courseDTO.getEndDate() == null) {
            return true; // Si alguna de las fechas es null, no validamos, se puede personalizar según se

        }

        return courseDTO.getEndDate().isAfter(courseDTO.getStartDate());
    }

}
