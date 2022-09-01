package com.cms.cloud.api.service;

import com.cms.cloud.api.spec.CategorySpecification;
import com.cms.cloud.api.dto.CategoryAddDto;
import com.cms.cloud.api.dto.CategorySearchDto;
import com.cms.cloud.api.dto.CategoryUpdateDto;
import com.cms.cloud.dao.entities.Category;
import com.cms.cloud.dao.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@EnableJpaRepositories(basePackages = {"com.cms.cloud.dao.repository"})
@EntityScan("com.cms.cloud.dao.entities")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryAddDto categoryAddDto) {

        Category category = new Category();
        category.setName(categoryAddDto.getName());
        category.setDescription(categoryAddDto.getDescription());
        category.setCreatedAt(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String categoryGuid) {

        categoryRepository.delete(categoryRepository.findById(categoryGuid).orElseThrow());
    }

    @Override
    public Category updateCategory(CategoryUpdateDto categoryUpdateDto) {

        Category category = categoryRepository.findById(categoryUpdateDto.getId()).orElseThrow();
        category.setName(categoryUpdateDto.getName());
        category.setDescription(categoryUpdateDto.getDescription());
        category.setModifiedAt(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategoryAll(CategorySearchDto categorySearchDto) {

        CategorySpecification categorySpecification = new CategorySpecification();

        List<Category> categoryList = categoryRepository.findAll(Specification.where(categorySpecification.search(categorySearchDto)));

        return categoryList;
    }

    @Override
    public Page<Category> searchCategory(CategorySearchDto categorySearchDto, Pageable pageable) {

        CategorySpecification categorySpecification = new CategorySpecification();
        Page<Category> categoryList = categoryRepository.findAll(Specification.where(categorySpecification.search(categorySearchDto)), pageable);

        return categoryList;
    }
}
