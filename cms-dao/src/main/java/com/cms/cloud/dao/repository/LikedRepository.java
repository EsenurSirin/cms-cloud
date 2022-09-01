package com.cms.cloud.dao.repository;

import com.cms.cloud.dao.entities.Liked;
import com.cms.cloud.dao.entities.LikedPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikedRepository extends JpaRepository<Liked, LikedPk>, JpaSpecificationExecutor<Liked> {

    @Query("select l from Liked l where l.likedPk.user.id =:userId and l.likedPk.article.id =:articleId")
    List<Liked> getLikedListByLiked(@Param("userId") String userId, @Param("articleId") String articleId);
}
