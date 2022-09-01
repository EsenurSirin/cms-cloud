package com.cms.cloud.api.validation;

import com.cms.cloud.dao.entities.Article;
import com.cms.cloud.dao.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueArticleNameValidator implements ConstraintValidator<UniqueArticleName, String> {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public boolean isValid(String articleTitle, ConstraintValidatorContext constraintValidatorContext) {

        List<Article> articleList = articleRepository.getArticleListByArticleTitle(articleTitle);
        return articleList.isEmpty();
    }
}
