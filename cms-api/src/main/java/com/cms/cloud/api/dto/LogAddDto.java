package com.cms.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogAddDto {

    @NotEmpty
    @NotBlank
    private String userName;

    @NotEmpty
    @NotBlank
    private String operation;

    @NotEmpty
    private String time;

    @NotEmpty
    private String method;

    @NotEmpty
    private String params;

    @NotEmpty
    private String logType;

    @NotEmpty
    private String ip;

    @PastOrPresent
    private Date created_at;
}
