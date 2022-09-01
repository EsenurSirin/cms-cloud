package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.CategorySearchDto;
import com.cms.cloud.dao.entities.Category;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CategorySpecification {

    public Specification<Category> search(CategorySearchDto categorySearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!ObjectUtils.isEmpty(categorySearchDto.getName())) {
                predicates.add(cb.equal(root.get("name"), categorySearchDto.getName()));
            }

            if (!ObjectUtils.isEmpty(categorySearchDto.getDescription())) {
                predicates.add(cb.like(root.get("description"), "%" + categorySearchDto.getDescription() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}