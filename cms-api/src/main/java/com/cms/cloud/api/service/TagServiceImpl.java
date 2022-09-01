package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.TagAddDto;
import com.cms.cloud.api.dto.TagSearchDto;
import com.cms.cloud.api.dto.TagUpdateDto;
import com.cms.cloud.api.spec.TagSpecification;
import com.cms.cloud.dao.entities.Tag;
import com.cms.cloud.dao.repository.TagRepository;
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
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public Tag addTag(TagAddDto tagAddDto) {

        Tag tag = new Tag();
        tag.setName(tagAddDto.getName());
        tag.setCreatedAt(new Date());
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(String tagGuid) {

        tagRepository.delete(tagRepository.findById(tagGuid).orElseThrow());
    }

    @Override
    public Tag updateTag(TagUpdateDto tagUpdateDto) {

        Tag tag = tagRepository.findById(tagUpdateDto.getTagId()).orElseThrow();
        tag.setName(tagUpdateDto.getName());
        tag.setModifiedAt(new Date());
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> searchTagAll(TagSearchDto tagSearchDto) {

        TagSpecification tagSpecification = new TagSpecification();
        List<Tag> tagList = tagRepository.findAll(Specification.where(tagSpecification.search(tagSearchDto)));
        return tagList;
    }

    @Override
    public Page<Tag> searchTag(TagSearchDto tagSearchDto, Pageable pageable) {

        TagSpecification tagSpecification = new TagSpecification();
        Page<Tag> tagList = tagRepository.findAll(Specification.where(tagSpecification.search(tagSearchDto)),
                pageable);
        return tagList;
    }
}
