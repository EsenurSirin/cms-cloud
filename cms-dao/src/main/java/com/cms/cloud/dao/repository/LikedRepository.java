package com.cms.cloud.dao.repository;

import com.cms.cloud.dao.entities.Liked;
import com.cms.cloud.dao.entities.LikedPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LikedRepository extends JpaRepository<Liked, LikedPk>, JpaSpecificationExecutor<Liked> {
}
