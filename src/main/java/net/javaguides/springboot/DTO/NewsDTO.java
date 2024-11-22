package net.javaguides.springboot.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import net.javaguides.springboot.Models.InterfaceNews;
import net.javaguides.springboot.Models.NewsCategory;
import net.javaguides.springboot.Models.User;

public class NewsDTO implements InterfaceNews {

    private Long id;
    private String imageUrl;
    private NewsCategory newCategory;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    private Boolean newsStatus;
    private User user;
    private LocalDate creationDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public NewsCategory getNewCategory() {
        return newCategory;
    }

    @Override
    public void setNewCategory(NewsCategory newCategory) {
        this.newCategory = newCategory;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public Boolean getNewsStatus() {
        return newsStatus;
    }

    @Override
    public void setNewsStatus(Boolean newsStatus) {
        this.newsStatus = newsStatus;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    @Override
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
