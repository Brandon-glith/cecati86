package net.javaguides.springboot.Models;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News implements InterfaceNews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private NewsCategory newCategory;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "news_status")
    private Boolean newsStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public News() {
        this.creationDate = LocalDate.now();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
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
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}
