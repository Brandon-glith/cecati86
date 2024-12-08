package net.javaguides.springboot.Models;

import java.time.LocalDate;

public interface InterfaceDocument {
    Long getId();

    void setId(Long id);

    // Métodos para el atributo 'documentName'
    String getDocumentName();

    void setDocumentName(String documentName);

    // Métodos para el atributo 'documentUrl'
    String getDocumentUrl();

    void setDocumentUrl(String documentUrl);

    // Métodos para el atributo 'uploadDate'
    LocalDate getUploadDate();

    void setUploadDate(LocalDate uploadDate);

    // Métodos para el atributo 'applicant'
    Applicant getApplicant();

    void setApplicant(Applicant applicant);

    // Métodos para el atributo 'course'
    Course getCourse();

    void setCourse(Course course);
}
