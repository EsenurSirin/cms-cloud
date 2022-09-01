package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.ArticleAddDto;
import com.cms.cloud.api.dto.ArticleSearchDto;
import com.cms.cloud.api.dto.ArticleUpdateDto;
import com.cms.cloud.dao.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {

    Article addArticle(ArticleAddDto articleAddDto);

    Article updateArticle(ArticleUpdateDto articleUpdateDto);

    void deleteArticle(String articleGuid);

    List<Article> getAllArticle();

    List<Article> searchArticleAll(ArticleSearchDto articleSearchDto);

    Page<Article> searchArticle(ArticleSearchDto articleSearchDto, Pageable pageable);
}