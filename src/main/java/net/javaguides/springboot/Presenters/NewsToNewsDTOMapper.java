package net.javaguides.springboot.Presenters;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.DTO.NewsDTO;
import net.javaguides.springboot.Models.News;

@Component
public class NewsToNewsDTOMapper implements InterfaceEntityToDTOMapper<NewsDTO, News> {

    
    @Override
    public NewsDTO convertToDTO(News news) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setImageUrl(news.getImageUrl());
        newsDTO.setNewCategory(news.getNewCategory());
        newsDTO.setExpirationDate(news.getExpirationDate());
        newsDTO.setNewsStatus(news.getNewsStatus());
        newsDTO.setUser(news.getUser());
        return newsDTO;
    }

}
