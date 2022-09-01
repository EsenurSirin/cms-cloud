package com.cms.cloud.api.service;

import com.cms.cloud.api.spec.LikedSpecification;
import com.cms.cloud.api.dto.LikedAddDto;
import com.cms.cloud.api.dto.LikedDeleteDto;
import com.cms.cloud.api.dto.LikedSearchDto;
import com.cms.cloud.dao.entities.Liked;
import com.cms.cloud.dao.entities.LikedPk;
import com.cms.cloud.dao.repository.ArticleRepository;
import com.cms.cloud.dao.repository.LikedRepository;
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
public class LikedServiceImpl implements LikedService {

    @Autowired
    LikedRepository likedRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Liked addLiked(LikedAddDto likedAddDto) {

        LikedPk likedPk = new LikedPk();
        likedPk.setArticle(articleRepository.findById(likedAddDto.getArticleId()).orElseThrow());
        likedPk.setUser(userRepository.findById(likedAddDto.getUserId()).orElseThrow());

        Liked liked = new Liked();
        liked.setLikedPk(likedPk);
        liked.setCreatedAt(new Date());
        return likedRepository.save(liked);
    }

    @Override
    public void deleteLiked(LikedDeleteDto likedDeleteDto) {

        LikedPk likedPk = new LikedPk();
        likedPk.setArticle(articleRepository.findById(likedDeleteDto.getArticleId()).orElseThrow());
        likedPk.setUser(userRepository.findById(likedDeleteDto.getUserId()).orElseThrow());
        likedRepository.delete(likedRepository.findById(likedPk).orElseThrow());
    }

    @Override
    public List<Liked> getAllLiked() {

        return likedRepository.findAll();
    }

    @Override
    public List<Liked> searchLikedAll(LikedSearchDto likedSearchDto) {

        LikedSpecification likedSpecification = new LikedSpecification();
        List<Liked> likedList = likedRepository.findAll(Specification.where(likedSpecification.search(likedSearchDto)));
        return likedList;
    }

    @Override
    public Page<Liked> searchLiked(LikedSearchDto likedSearchDto, Pageable pageable) {

        LikedSpecification likedSpecification = new LikedSpecification();
        Page<Liked> likedList = likedRepository.findAll(Specification.where(likedSpecification.search(likedSearchDto)),
                pageable);
        return likedList;
    }
}
