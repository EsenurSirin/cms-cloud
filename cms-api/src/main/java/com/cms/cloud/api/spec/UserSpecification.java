package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.UserSearchDto;
import com.cms.cloud.dao.entities.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification {

    public Specification<User> search(UserSearchDto userSearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!ObjectUtils.isEmpty(userSearchDto.getFirstName())) {
                predicates.add(cb.like(root.get("firstName"), "%" + userSearchDto.getFirstName()));
            }
            if (!ObjectUtils.isEmpty(userSearchDto.getLastName())) {
                predicates.add(cb.like(root.get("lastName"), "%" + userSearchDto.getLastName()));
            }
            if (!ObjectUtils.isEmpty(userSearchDto.getUserName())) {
                predicates.add(cb.equal(root.get("userName"), userSearchDto.getUserName()));
            }
            if (!ObjectUtils.isEmpty(userSearchDto.getEmail())) {
                predicates.add(cb.equal(root.get("email"), userSearchDto.getEmail()));
            }

            if (!ObjectUtils.isEmpty(userSearchDto.getDateOfBirth())) {
                predicates.add(cb.equal(root.get("dateOfBirth"), userSearchDto.getDateOfBirth()));
            }
            if (!ObjectUtils.isEmpty(userSearchDto.getTelephone())) {
                predicates.add(cb.equal(root.get("telephone"), userSearchDto.getTelephone()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}