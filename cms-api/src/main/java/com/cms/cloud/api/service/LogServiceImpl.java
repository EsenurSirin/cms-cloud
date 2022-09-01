package com.cms.cloud.api.service;

import com.cms.cloud.api.spec.LogSpecification;
import com.cms.cloud.api.dto.LogAddDto;
import com.cms.cloud.api.dto.LogSearchDto;
import com.cms.cloud.dao.entities.Log;
import com.cms.cloud.dao.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@EnableJpaRepositories(basePackages = {"com.cms.cloud.dao.repository"})
@EntityScan("com.cms.cloud.dao.entities")
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepository logRepository;

    @Override
    public Log createLog(LogAddDto logAddDto) {

        Log log = new Log();
        log.setIp(logAddDto.getIp());
        log.setUserName(logAddDto.getUserName());
        log.setTime(logAddDto.getTime());
        log.setParams(logAddDto.getParams());
        log.setOperation(logAddDto.getOperation());
        log.setLogType(logAddDto.getLogType());
        log.setCreated_at(new Date());
        log.setMethod(logAddDto.getMethod());
        return logRepository.save(log);
    }

    @Override
    public void deleteLog(String logGuid) {
        logRepository.delete(logRepository.findById(logGuid).orElseThrow());
    }

    @Override
    public List<Log> searchLogAll(LogSearchDto logSearchDto) {

        LogSpecification logSpecification = new LogSpecification();

        List<Log> logList = logRepository.findAll(Specification.where(logSpecification.search(logSearchDto)));

        return logList;
    }

    @Override
    public Page<Log> searchLog(LogSearchDto logSearchDto, Pageable pageable) {

        LogSpecification logSpecification = new LogSpecification();
        Page<Log> logList = logRepository.findAll(Specification.where(logSpecification.search(logSearchDto)), pageable);

        return logList;
    }
}
