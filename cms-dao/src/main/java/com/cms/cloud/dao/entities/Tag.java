package com.cms.cloud.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tag", schema = "public")
public class Tag extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;


    @Temporal(TemporalType.DATE)
    @Column(name = "modified_at")
    private Date modifiedAt;
}
