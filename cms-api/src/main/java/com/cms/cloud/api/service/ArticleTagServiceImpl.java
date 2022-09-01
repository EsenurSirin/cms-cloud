package com.cms.cloud.api.service;

import com.cms.cloud.api.spec.ArticleTagSpecification;
import com.cms.cloud.api.dto.ArticleTagAddDto;
import com.cms.cloud.api.dto.ArticleTagSearchDto;
import com.cms.cloud.api.dto.ArticleTagUpdateDto;
import com.cms.cloud.dao.entities.ArticleTag;
import com.cms.cloud.dao.repository.ArticleRepository;
import com.cms.cloud.dao.repository.ArticleTagRepository;
import com.cms.cloud.dao.repository.TagRepository;
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
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    ArticleTagRepository articleTagRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    TagRepository tagRepository;

    @Override
    public ArticleTag addArticleTag(ArticleTagAddDto articleTagAddDto) {

        ArticleTag articleTag = new ArticleTag();
        articleTag.setArticle(articleRepository.findById(articleTagAddDto.getArticleId()).orElseThrow());
        articleTag.setTag(tagRepository.findById(articleTagAddDto.getTagId()).orElseThrow());
        articleTag.setCreatedAt(new Date());
        return articleTagRepository.save(articleTag);
    }

    @Override
    public ArticleTag updateArticleTag(ArticleTagUpdateDto articleTagUpdateDto) {

        ArticleTag articleTag = articleTagRepository.findById(articleTagUpdateDto.getArticleTagId()).orElseThrow();
        articleTag.setArticle(articleRepository.findById(articleTagUpdateDto.getArticleId()).orElseThrow());
        articleTag.setTag(tagRepository.findById(articleTagUpdateDto.getTagId()).orElseThrow());
        articleTag.setModifiedAt(new Date());
        return articleTagRepository.save(articleTag);
    }

    @Override
    public void deleteArticleTag(String articleTagGuid) {

        articleTagRepository.delete(articleTagRepository.findById(articleTagGuid).orElseThrow());
    }

    @Override
    public List<ArticleTag> getAllArticleTag() {
        return articleTagRepository.findAll();
    }

    @Override
    public List<ArticleTag> searchArticleTagAll(ArticleTagSearchDto articleTagSearchDto) {

        ArticleTagSpecification articleTagSpecification = new ArticleTagSpecification();
        List<ArticleTag> articleTagList = articleTagRepository.findAll(Specification.where(articleTagSpecification.search(articleTagSearchDto)));
        return articleTagList;
    }

    @Override
    public Page<ArticleTag> searchArticleTag(ArticleTagSearchDto articleTagSearchDto, Pageable pageable) {

        ArticleTagSpecification articleTagSpecification = new ArticleTagSpecification();
        Page<ArticleTag> articleTagList = articleTagRepository.findAll(Specification.where(articleTagSpecification.search(articleTagSearchDto)),
                pageable);
        return articleTagList;
    }
}
