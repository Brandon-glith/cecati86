package net.javaguides.springboot.Presenters;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.DTO.NewsCategoryDTO;
import net.javaguides.springboot.Models.NewsCategory;

@Component
public class NewsCategoryToNewsCategoryDTOMapper implements InterfaceEntityToDTOMapper<NewsCategoryDTO, NewsCategory> {

    @Override
    public NewsCategoryDTO convertToDTO(NewsCategory newsCategory) {
        NewsCategoryDTO newsCategoryDTO = new NewsCategoryDTO();
        newsCategoryDTO.setId(newsCategory.getId());
        newsCategoryDTO.setName(newsCategory.getName());
        return newsCategoryDTO;
    }

}
