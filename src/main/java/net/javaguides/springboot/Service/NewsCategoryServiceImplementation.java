package net.javaguides.springboot.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.DTO.NewsCategoryDTO;
import net.javaguides.springboot.Presenters.NewsCategoryToNewsCategoryDTOMapper;
import net.javaguides.springboot.Repository.InterfaceNewsCategoryRepository;

@Service
public class NewsCategoryServiceImplementation implements InterfaceNewsCategoryService {

    @Autowired
    private NewsCategoryToNewsCategoryDTOMapper categoryToNewsCategoryDTOMapper;

    @Autowired
    InterfaceNewsCategoryRepository categoryRepository;

    @Override
    public List<NewsCategoryDTO> getAllNewsCategoriesDTOs() {
        return categoryRepository.findAll().stream().map(
                categoryToNewsCategoryDTOMapper::convertToDTO)
                .collect(Collectors.toList());
    }

}
