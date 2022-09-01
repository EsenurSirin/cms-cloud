package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.LogAddDto;
import com.cms.cloud.api.dto.LogSearchDto;
import com.cms.cloud.dao.entities.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LogService {

    Log createLog(LogAddDto logAddDto);

    void deleteLog(String logGuid);

    List<Log> searchLogAll(LogSearchDto logSearchDto);

    Page<Log> searchLog(LogSearchDto logSearchDto, Pageable pageable);
}
