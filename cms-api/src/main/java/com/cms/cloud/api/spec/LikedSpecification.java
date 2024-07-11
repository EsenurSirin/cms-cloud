

package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.LikedSearchDto;
import com.cms.cloud.dao.entities.Liked;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class LikedSpecification {

    public Specification<Liked> search(LikedSearchDto likedSearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!ObjectUtils.isEmpty(likedSearchDto.getArticleId())) {
                predicates.add(cb.equal(root.join("article").get("id"), likedSearchDto.getArticleId()));

            }
            if (!ObjectUtils.isEmpty(likedSearchDto.getUserId())) {
                predicates.add(cb.equal(root.join("user").get("id"), likedSearchDto.getUserId()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
