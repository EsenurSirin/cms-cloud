package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.ArticleSearchDto;
import com.cms.cloud.dao.entities.Article;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ArticleSpecification {

    public Specification<Article> search(ArticleSearchDto articleSearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!ObjectUtils.isEmpty(articleSearchDto.getCategoryId())) {
                predicates.add(cb.equal(root.join("category").get("id"), articleSearchDto.getCategoryId()));

            }
            if (!ObjectUtils.isEmpty(articleSearchDto.getUserId())) {
                predicates.add(cb.like(root.join("user").get("id"), articleSearchDto.getUserId()));
            }

            if (!ObjectUtils.isEmpty(articleSearchDto.getContent())) {
                predicates.add(cb.equal(root.get("content"), articleSearchDto.getContent()));
            }

            if (!ObjectUtils.isEmpty(articleSearchDto.getTitle())) {
                predicates.add(cb.equal(root.get("title"), articleSearchDto.getTitle()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}