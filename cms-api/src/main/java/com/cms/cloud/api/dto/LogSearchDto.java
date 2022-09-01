package com.cms.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogSearchDto {

    private String userName;

    private String operation;

    private String time;

    private String method;

    private String params;

    private String ip;

    private Date created_at;

    private String logType;
}
