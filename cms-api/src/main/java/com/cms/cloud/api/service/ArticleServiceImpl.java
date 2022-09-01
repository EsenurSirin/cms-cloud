package com.cms.cloud.api.service;

import com.cms.cloud.api.spec.ArticleSpecification;
import com.cms.cloud.api.dto.ArticleAddDto;
import com.cms.cloud.api.dto.ArticleSearchDto;
import com.cms.cloud.api.dto.ArticleUpdateDto;
import com.cms.cloud.dao.entities.Article;
import com.cms.cloud.dao.repository.ArticleRepository;
import com.cms.cloud.dao.repository.CategoryRepository;
import com.cms.cloud.dao.repository.UserRepository;
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
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Article addArticle(ArticleAddDto articleAddDto) {

        Article article = new Article();
        article.setCategory(categoryRepository.findById(articleAddDto.getCategoryId()).orElseThrow());
        article.setUser(userRepository.findById(articleAddDto.getUserId()).orElseThrow());
        article.setTitle(articleAddDto.getTitle());
        article.setContent(articleAddDto.getContent());
        article.setCreatedAt(new Date());
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(ArticleUpdateDto articleUpdateDto) {

        Article article = articleRepository.findById(articleUpdateDto.getArticleId()).orElseThrow();
        article.setCategory(categoryRepository.findById(articleUpdateDto.getCategoryId()).orElseThrow());
        article.setUser(userRepository.findById(articleUpdateDto.getUserId()).orElseThrow());
        article.setContent(articleUpdateDto.getContent());
        article.setTitle(articleUpdateDto.getTitle());
        article.setModifiedAt(new Date());
        return articleRepository.save(article);
    }

    @Override
    public void deleteArticle(String articleGuid) {

        articleRepository.delete(articleRepository.findById(articleGuid).orElseThrow());

    }

    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public List<Article> searchArticleAll(ArticleSearchDto articleSearchDto) {

        ArticleSpecification articleSpecification = new ArticleSpecification();
        List<Article> articleList = articleRepository.findAll(Specification.where(articleSpecification.search(articleSearchDto)));
        return articleList;
    }

    @Override
    public Page<Article> searchArticle(ArticleSearchDto articleSearchDto, Pageable pageable) {

        ArticleSpecification articleSpecification = new ArticleSpecification();
        Page<Article> articleList = articleRepository.findAll(Specification.where(articleSpecification.search(articleSearchDto)), pageable);
        return articleList;
    }
}