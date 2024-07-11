package com.cms.cloud.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "log", schema = "public")
public class Log extends BaseEntity {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "operation")
    private String operation;

    @Column(name = "time")
    private String time;

    @Column(name = "method")
    private String method;

    @Column(name = "params")
    private String params;

    @Column(name = "logType")
    private String logType;

    @Column(name = "ip")
    private String ip;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date created_at;
}
