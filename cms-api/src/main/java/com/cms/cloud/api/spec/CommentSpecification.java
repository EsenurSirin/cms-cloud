package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.CommentSearchDto;
import com.cms.cloud.dao.entities.Comment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CommentSpecification {

    public Specification<Comment> search(CommentSearchDto commentSearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!ObjectUtils.isEmpty(commentSearchDto.getContent())) {
                predicates.add(cb.equal(root.get("content"), commentSearchDto.getContent()));
            }

            if (!ObjectUtils.isEmpty(commentSearchDto.getArticleId())) {
                predicates.add(cb.equal(root.join("article").get("id"), commentSearchDto.getArticleId()));

            }
            if (!ObjectUtils.isEmpty(commentSearchDto.getUserId())) {
                predicates.add(cb.like(root.join("user").get("id"), commentSearchDto.getUserId()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}