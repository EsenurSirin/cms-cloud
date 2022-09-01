package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.LikedAddDto;
import com.cms.cloud.api.dto.LikedDeleteDto;
import com.cms.cloud.api.dto.LikedSearchDto;
import com.cms.cloud.dao.entities.Liked;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LikedService {

    Liked addLiked(LikedAddDto likedAddDto);

    void deleteLiked(LikedDeleteDto likedDeleteDto);

    List<Liked> getAllLiked();

    List<Liked> searchLikedAll(LikedSearchDto likedSearchDto);

    Page<Liked> searchLiked(LikedSearchDto likedSearchDto, Pageable pageable);
}
