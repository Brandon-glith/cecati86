package net.javaguides.springboot.Service;

import java.util.List;

import net.javaguides.springboot.DTO.NewsDTO;
import net.javaguides.springboot.Models.News;

public interface InterfaceNewsService {

    void saveNews(NewsDTO news);

    List<NewsDTO> getAllNewsDTOs();

    Long totalNews();
}
