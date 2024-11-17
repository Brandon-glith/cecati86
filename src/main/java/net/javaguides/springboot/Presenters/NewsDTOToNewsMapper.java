package net.javaguides.springboot.Presenters;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.DTO.NewsDTO;
import net.javaguides.springboot.Models.News;

@Component
public class NewsDTOToNewsMapper implements InterfaceDTOToEntityMapper<NewsDTO, News> {

    @Override
    public News convertToEntity(NewsDTO newsDTO) {
        News news = new News();
        news.setImageUrl(newsDTO.getImageUrl());
        news.setExpirationDate(newsDTO.getExpirationDate());
        news.setNewCategory(newsDTO.getNewCategory());
        news.setNewsStatus(newsDTO.getNewsStatus());
        return news;
    }

}
