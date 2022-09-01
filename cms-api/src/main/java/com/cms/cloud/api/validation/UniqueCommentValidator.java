package com.cms.cloud.api.validation;

import com.cms.cloud.api.dto.CommentAddDto;
import com.cms.cloud.dao.entities.Comment;
import com.cms.cloud.dao.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueCommentValidator implements ConstraintValidator<UniqueComment, CommentAddDto> {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public boolean isValid(CommentAddDto commentAddDto, ConstraintValidatorContext constraintValidatorContext) {
        List<Comment> commentList = commentRepository.getCommentListByComment(commentAddDto.getUserId(), commentAddDto.getArticleId());

        if (commentList.size() >= 10) {
            return false;
        } else {
            return true;
        }
    }
}
