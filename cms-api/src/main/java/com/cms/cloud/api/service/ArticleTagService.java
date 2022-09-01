package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.ArticleTagAddDto;
import com.cms.cloud.api.dto.ArticleTagSearchDto;
import com.cms.cloud.api.dto.ArticleTagUpdateDto;
import com.cms.cloud.dao.entities.ArticleTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleTagService {

    ArticleTag addArticleTag(ArticleTagAddDto articleTagAddDto);

    ArticleTag updateArticleTag(ArticleTagUpdateDto articleTagUpdateDto);

    void deleteArticleTag(String articleTagGuid);

    List<ArticleTag> getAllArticleTag();

    List<ArticleTag> searchArticleTagAll(ArticleTagSearchDto articleTagSearchDto);

    Page<ArticleTag> searchArticleTag(ArticleTagSearchDto articleTagSearchDto, Pageable pageable);
}