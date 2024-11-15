package net.javaguides.springboot.Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course implements InterfaceCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name", nullable = false)
    private String courseName;
    @Column(name = "description", length = 500)
    private String description;
    @Column(name = "duration_hours")
    private int DURATION_HOURS;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "cost", precision = 10, scale = 2)
    private BigDecimal cost;
    @Column(name = "course_type")
    private String courseType;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "aspirant_limit")
    private byte LIMIT;
    @ManyToMany(mappedBy = "courses")
    private Set<Applicant> applicants = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getDurationHours() {
        return DURATION_HOURS;
    }

    @Override
    public void setDurationHours(int durationHours) {
        this.DURATION_HOURS = durationHours;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String getCourseType() {
        return courseType;
    }

    @Override
    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public byte getAspirantLimit() {
        return this.LIMIT;
    }

    @Override
    public void setAspirantLimit(byte limit) {
        this.LIMIT = limit;
    }

}
