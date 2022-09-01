package com.cms.cloud.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "liked", schema = "cms")
public class Liked {

    @EmbeddedId
    private LikedPk likedPk;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;
}
