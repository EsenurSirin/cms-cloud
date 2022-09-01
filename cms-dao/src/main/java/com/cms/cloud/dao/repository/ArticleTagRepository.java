package com.cms.cloud.dao.repository;

import com.cms.cloud.dao.entities.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, String>, JpaSpecificationExecutor<ArticleTag> {

    @Query("select a from ArticleTag a where a.tag.id =:tagId and a.article.id =:articleId")
    List<ArticleTag> getArticleTagListByArticleTag(@Param("tagId") String tagId,
                                                   @Param("articleId") String articleId);
}