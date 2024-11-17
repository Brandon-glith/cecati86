package net.javaguides.springboot.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTO.NewsDTO;
import net.javaguides.springboot.Models.News;
import net.javaguides.springboot.Presenters.NewsDTOToNewsMapper;
import net.javaguides.springboot.Presenters.NewsToNewsDTOMapper;
import net.javaguides.springboot.Presenters.NewsToNewsDTOMapper;
import net.javaguides.springboot.Repository.InterfaceNewsRepository;

@Service
public class NewsServiceImplementation implements InterfaceNewsService {

    @Autowired
    InterfaceNewsRepository newsRepository;

    @Autowired
    NewsToNewsDTOMapper newsMapper;

    @Autowired
    NewsDTOToNewsMapper dtoToNewsMapper;

    @Override
    public void saveNews(NewsDTO newsDTO) {
        newsRepository.save(dtoToNewsMapper.convertToEntity(newsDTO));
    }

    @Override
    public List<NewsDTO> getAllNewsDTOs() {
        return newsRepository.findAll().stream().map(
                newsMapper::convertToDTO).collect(
                        Collectors.toList());
    }

    @Override
    public Long totalNews() {
        return newsRepository.count();
    }

}
