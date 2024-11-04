package net.javaguides.springboot.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface InterfaceCourse {

    Long getId();

    void setId(Long id); // Assuming the ID is a string; change to int if needed

    String getCourseName();

    void setCourseName(String name);

    String getDescription();

    void setDescription(String description);

    int getDurationHours();

    void setDurationHours(int durationHours);

    BigDecimal getCost();

    void setCost(BigDecimal cost);

    LocalDate getStartDate();

    void setStartDate(LocalDate startDate);

    LocalDate getEndDate();

    void setEndDate(LocalDate endDate);

    String getCourseType(); // Example: in-person, online, hybrid

    void setCourseType(String courseType);

    String getImagePath(); // Path to the course image

    void setImagePath(String imagePath); // Set the image path

    byte getAspirantLimit();
}
