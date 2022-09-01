package com.cms.cloud.api.service;

import com.cms.cloud.api.spec.CommentSpecification;
import com.cms.cloud.api.dto.CommentAddDto;
import com.cms.cloud.api.dto.CommentSearchDto;
import com.cms.cloud.api.dto.CommentUpdateDto;
import com.cms.cloud.dao.entities.Comment;
import com.cms.cloud.dao.repository.ArticleRepository;
import com.cms.cloud.dao.repository.CommentRepository;
import com.cms.cloud.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@EnableJpaRepositories(basePackages = {"com.cms.cloud.dao.repository"})
@EntityScan("com.cms.cloud.dao.entities")
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Comment addComment(CommentAddDto commentAddDto) {

        Comment comment = new Comment();
        comment.setArticle(articleRepository.findById(commentAddDto.getArticleId()).orElseThrow());
        comment.setUser(userRepository.findById(commentAddDto.getUserId()).orElseThrow());
        comment.setContent(commentAddDto.getContent());
        comment.setCreatedAt(new Date());
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(CommentUpdateDto commentUpdateDto) {

        Comment comment = commentRepository.findById(commentUpdateDto.getCommentId()).orElseThrow();
        comment.setArticle(articleRepository.findById(commentUpdateDto.getArticleId()).orElseThrow());
        comment.setUser(userRepository.findById(commentUpdateDto.getUserId()).orElseThrow());
        comment.setContent(commentUpdateDto.getContent());
        comment.setModifiedAt(new Date());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(String commentGuid) {

        commentRepository.delete(commentRepository.findById(commentGuid).orElseThrow());
    }

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> searchCommentAll(CommentSearchDto commentSearchDto) {

        CommentSpecification commentSpecification = new CommentSpecification();
        List<Comment> commentList = commentRepository.findAll(Specification.where(commentSpecification.search(commentSearchDto)));
        return commentList;
    }

    @Override
    public Page<Comment> searchComment(CommentSearchDto commentSearchDto, Pageable pageable) {

        CommentSpecification commentSpecification = new CommentSpecification();
        Page<Comment> commentList = commentRepository.findAll(Specification.where(commentSpecification.search(commentSearchDto)), pageable);
        return commentList;
    }
}
