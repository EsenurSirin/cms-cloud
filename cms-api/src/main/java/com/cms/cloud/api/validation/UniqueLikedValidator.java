package com.cms.cloud.api.validation;

import com.cms.cloud.api.dto.LikedAddDto;
import com.cms.cloud.dao.entities.Liked;
import com.cms.cloud.dao.repository.LikedRepository;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueLikedValidator implements ConstraintValidator<UniqueLiked, LikedAddDto> {

    @Autowired
    LikedRepository likedRepository;

    @Override
    public boolean isValid(LikedAddDto likedAddDto, ConstraintValidatorContext constraintValidatorContext) {

        List<Liked> likedList = likedRepository.getLikedListByLiked(likedAddDto.getUserId(), likedAddDto.getArticleId());
        return likedList.isEmpty();
    }
}
