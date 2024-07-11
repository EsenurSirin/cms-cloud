package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.TagSearchDto;
import com.cms.cloud.dao.entities.Tag;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class TagSpecification {

    public Specification<Tag> search(TagSearchDto tagSearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();


            if (!ObjectUtils.isEmpty(tagSearchDto.getName())) {
                predicates.add(cb.equal(root.get("name"), tagSearchDto.getName()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
