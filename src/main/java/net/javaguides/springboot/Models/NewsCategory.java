package net.javaguides.springboot.Models;

import javax.persistence.*;

@Entity
@Table(name = "news_category")
public class NewsCategory implements InterfaceNewsCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name")
    private String name;

    public NewsCategory() {

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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
