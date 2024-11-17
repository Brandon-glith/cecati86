package net.javaguides.springboot.Models;

import java.time.LocalDate;

public interface InterfaceNews {

    Long getId();

    void setId(Long id);

    void setCreationDate(LocalDate creationDate);

    LocalDate getCreationDate();

    String getImageUrl();

    void setImageUrl(String imageUrl);

    NewsCategory getNewCategory();

    void setNewCategory(NewsCategory newCategory);

    LocalDate getExpirationDate();

    void setExpirationDate(LocalDate expirationDate);

    Boolean getNewsStatus();

    void setNewsStatus(Boolean newsStatus);

    User getUser();

    void setUser(User user);

}
