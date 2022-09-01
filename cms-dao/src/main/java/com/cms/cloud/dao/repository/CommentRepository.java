package com.cms.cloud.dao.repository;

import com.cms.cloud.dao.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String>, JpaSpecificationExecutor<Comment> {

    @Query("select c from Comment c where c.user.id =:userId and c.article.id =:articleId")
    List<Comment> getCommentListByComment(@Param("userId") String userId,
                                          @Param("articleId") String articleId);
}