package com.cms.cloud.api.controller;

import com.cms.cloud.api.service.LogService;
import com.cms.cloud.api.dto.LogAddDto;
import com.cms.cloud.api.dto.LogSearchDto;
import com.cms.cloud.dao.entities.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/api/log")
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping("/create-log")
    public ResponseEntity create(@RequestBody @Valid LogAddDto logAddDto) {
        logService.createLog(logAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-log")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty String id) {
        logService.deleteLog(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/search-log-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Log>> searchLogAll(@RequestBody LogSearchDto logSearchDto) {
        return ResponseEntity.ok(logService.searchLogAll(logSearchDto));
    }

    @PostMapping(value = "/search-log",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Log>> searchLog(@RequestBody LogSearchDto logSearchDto, Pageable pageable) {
        return ResponseEntity.ok(logService.searchLog(logSearchDto, pageable));
    }
}
