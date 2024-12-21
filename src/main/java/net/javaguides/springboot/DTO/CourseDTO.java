package net.javaguides.springboot.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import net.javaguides.springboot.ApplicationLayer.ValidDateRange;
import net.javaguides.springboot.Models.Applicant;

@ValidDateRange
public class CourseDTO {

    private Long id;
    @NotBlank(message = "El nombre del curso no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre del curso debe tener entre 3 y 100 caracteres")
    @Pattern(regexp = "^[A-Za-záéíóúÁÉÍÓÚ0-9 ]+$", message = "El nombre del curso solo puede contener letras, números y espacios")
    private String courseName;
    @Size(max = 334, message = "¡La descripción del curso es demasiado larga!")
    private String description;
    @Min(value = 1, message = "La duración del curso debe ser al menos de 1 hora.")
    private int durationHours;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate; // Fecha de inicio
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate endDate; // Fecha de terminación

    @Positive(message = "El costo debe ser un valor positivo.")
    private BigDecimal cost;
    private String courseType;
    private String imagePath;
    @Positive(message = "El limite de aspirantes debe ser positivo.")
    private byte aspirantLimit;

    private Set<Applicant> applicants;

    // Getters y Setters

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "CourseDTO{\n" +
                "courseName: '" + getCourseName() + "'\n" +
                "description: '" + getDescription() + "'\n" +
                "durationHours: " + getDurationHours() + "\n" +
                "startDate: " + getStartDate() + "\n" +
                "endDate: " + getEndDate() + "\n" +
                "cost: " + getCost().doubleValue() + "\n" +
                "courseType: '" + getCourseType() + "'\n" +
                "imagePath: '" + getImagePath() + "'\n" +
                "ASPIRANT_LIMIT: " + getAspirantLimit() + "\n" +
                '}';
    }

    public byte getAspirantLimit() {
        return aspirantLimit;
    }

    public void setAspirantLimit(byte aspirantLimit) {
        this.aspirantLimit = aspirantLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(Set<Applicant> applicants) {
        this.applicants = applicants;
    }

}
