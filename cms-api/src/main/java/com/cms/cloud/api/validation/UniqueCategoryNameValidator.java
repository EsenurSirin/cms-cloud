package com.cms.cloud.api.validation;

import com.cms.cloud.dao.entities.Category;
import com.cms.cloud.dao.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName, String> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String categoryName, ConstraintValidatorContext constraintValidatorContext) {

        List<Category> categoryList = categoryRepository.getCategoryListByCategoryName(categoryName);
        return categoryList.isEmpty();
    }
}