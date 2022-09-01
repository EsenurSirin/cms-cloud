package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.CategoryAddDto;
import com.cms.cloud.api.dto.CategorySearchDto;
import com.cms.cloud.api.dto.CategoryUpdateDto;
import com.cms.cloud.dao.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    Category addCategory(CategoryAddDto categoryAddDto);

    void deleteCategory(String categoryGuid);

    Category updateCategory(CategoryUpdateDto categoryUpdateDto);

    List<Category> getAllCategory();

    List<Category> searchCategoryAll(CategorySearchDto categorySearchDto);

    Page<Category> searchCategory(CategorySearchDto categorySearchDto, Pageable pageable);
}
