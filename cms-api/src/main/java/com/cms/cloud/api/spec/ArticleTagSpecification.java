package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.ArticleTagSearchDto;
import com.cms.cloud.dao.entities.ArticleTag;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ArticleTagSpecification {

    public Specification<ArticleTag> search(ArticleTagSearchDto articleTagSearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();


            if (!ObjectUtils.isEmpty(articleTagSearchDto.getArticleId())) {
                predicates.add(cb.equal(root.join("article").get("id"), articleTagSearchDto.getArticleId()));

            }
            if (!ObjectUtils.isEmpty(articleTagSearchDto.getTagId())) {
                predicates.add(cb.equal(root.join("tag").get("id"), articleTagSearchDto.getTagId()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}