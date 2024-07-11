package com.cms.cloud.api.spec;

import com.cms.cloud.api.dto.LogSearchDto;
import com.cms.cloud.dao.entities.Log;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class LogSpecification {

    public Specification<Log> search(LogSearchDto logSearchDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();


            if (!ObjectUtils.isEmpty(logSearchDto.getUserName())) {
                predicates.add(cb.like(root.get("userName"), "%" + logSearchDto.getUserName()));
            }
            if (!ObjectUtils.isEmpty(logSearchDto.getCreated_at())) {
                predicates.add(cb.equal(root.get("created_at"), logSearchDto.getCreated_at()));
            }
            if (!ObjectUtils.isEmpty(logSearchDto.getTime())) {
                predicates.add(cb.equal(root.get("time"), logSearchDto.getTime()));
            }
            if (!ObjectUtils.isEmpty(logSearchDto.getIp())) {
                predicates.add(cb.equal(root.get("ip"), logSearchDto.getIp()));
            }

            if (!ObjectUtils.isEmpty(logSearchDto.getMethod())) {
                predicates.add(cb.like(root.get("method"), "%" + logSearchDto.getMethod()));
            }
            if (!ObjectUtils.isEmpty(logSearchDto.getOperation())) {
                predicates.add(cb.like(root.get("operation"), "%" + logSearchDto.getOperation()));
            }

            if (!ObjectUtils.isEmpty(logSearchDto.getParams())) {
                predicates.add(cb.like(root.get("params"), "%" + logSearchDto.getParams()));
            }

            if (!ObjectUtils.isEmpty(logSearchDto.getLogType())) {
                predicates.add(cb.like(root.get("logType"), "%" + logSearchDto.getLogType()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
