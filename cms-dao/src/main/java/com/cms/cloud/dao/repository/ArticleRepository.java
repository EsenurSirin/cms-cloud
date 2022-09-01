package com.cms.cloud.dao.repository;

import com.cms.cloud.dao.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

    @Query("select a from Article a where a.title =:articleTitle")
    List<Article> getArticleListByArticleTitle(@Param("articleTitle") String articleTitle);
}

