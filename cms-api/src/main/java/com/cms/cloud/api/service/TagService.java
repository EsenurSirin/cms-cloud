package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.TagAddDto;
import com.cms.cloud.api.dto.TagSearchDto;
import com.cms.cloud.api.dto.TagUpdateDto;
import com.cms.cloud.dao.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {

    Tag addTag(TagAddDto tagAddDto);

    void deleteTag(String tagGuid);

    Tag updateTag(TagUpdateDto tagUpdateDto);

    List<Tag> getAllTag();

    List<Tag> searchTagAll(TagSearchDto tagSearchDto);

    Page<Tag> searchTag(TagSearchDto tagSearchDto, Pageable pageable);
}
