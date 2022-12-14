package com.cms.cloud.api.aop;

import com.cms.cloud.api.service.LogService;
import com.cms.cloud.api.dto.LogAddDto;
import com.cms.cloud.core.util.HttpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    LogService logService;

    Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "@annotation(log)", argNames = "log")
    public void myPointcut(Log log) {

    }

    @Around("myPointcut(com.cms.cloud.api.aop.Log)")
    public void applicationLogger(ProceedingJoinPoint pjp) throws Throwable {

        LogAddDto logAddDto = new LogAddDto();
        logAddDto.setIp(HttpUtil.getClientIpAddressIfServletRequestExist());
        logAddDto.setCreated_at(new Date());
        logAddDto.setUserName("default-log");
        logAddDto.setLogType("integer");
        logAddDto.setTime("10:11");
        logAddDto.setMethod("params");
        logAddDto.setOperation("delete");
        logService.createLog(logAddDto);
    }
}