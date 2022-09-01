package com.cms.cloud.api.validation;

import com.cms.cloud.api.dto.ArticleTagAddDto;
import com.cms.cloud.dao.entities.ArticleTag;
import com.cms.cloud.dao.repository.ArticleTagRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueArticleTagValidator implements ConstraintValidator<UniqueArticleTag, ArticleTagAddDto> {

    @Autowired
    ArticleTagRepository articleTagRepository;

    @Override
    public boolean isValid(ArticleTagAddDto articleTagAddDto, ConstraintValidatorContext constraintValidatorContext) {

        List<ArticleTag> articleTagList = articleTagRepository.getArticleTagListByArticleTag(articleTagAddDto.getTagId(), articleTagAddDto.getArticleId());
        return articleTagList.isEmpty();
    }
}
