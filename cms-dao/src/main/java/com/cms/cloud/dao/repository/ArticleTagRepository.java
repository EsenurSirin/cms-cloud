package com.cms.cloud.dao.repository;

import com.cms.cloud.dao.entities.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, String>, JpaSpecificationExecutor<ArticleTag> {
}
