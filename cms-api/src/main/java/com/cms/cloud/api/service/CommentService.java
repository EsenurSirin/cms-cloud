package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.CommentAddDto;
import com.cms.cloud.api.dto.CommentSearchDto;
import com.cms.cloud.api.dto.CommentUpdateDto;
import com.cms.cloud.dao.entities.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    Comment addComment(CommentAddDto commentAddDto);

    Comment updateComment(CommentUpdateDto commentUpdateDto);

    void deleteComment(String commentGuid);

    List<Comment> getAllComment();

    List<Comment> searchCommentAll(CommentSearchDto commentSearchDto);

    Page<Comment> searchComment(CommentSearchDto commentSearchDto, Pageable pageable);
}
