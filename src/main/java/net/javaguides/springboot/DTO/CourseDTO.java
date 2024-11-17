package net.javaguides.springboot.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class CourseDTO {

    private Long id;
    private String courseName;
    private String description;
    private int durationHours;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate; // Fecha de inicio
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate; // Fecha de terminación
    private BigDecimal cost;
    private String courseType;
    private String imagePath;
    private byte aspirantLimit;

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

}
