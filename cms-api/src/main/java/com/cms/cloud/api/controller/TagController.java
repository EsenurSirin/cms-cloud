package com.cms.cloud.api.controller;

import com.cms.cloud.api.service.TagService;
import com.cms.cloud.api.dto.TagAddDto;
import com.cms.cloud.api.dto.TagSearchDto;
import com.cms.cloud.api.dto.TagUpdateDto;
import com.cms.cloud.dao.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("/add-tag")
    public ResponseEntity add(@RequestBody @Valid TagAddDto tagAddDto) {
        tagService.addTag(tagAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-tag")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty String id) {
        tagService.deleteTag(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("/update-tag")
    public ResponseEntity update(@RequestBody @Valid TagUpdateDto tagUpdateDto) {
        tagService.updateTag(tagUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list-tag")
    public ResponseEntity<List<Tag>> getAll() {
        return ResponseEntity.ok(tagService.getAllTag());
    }

    @PostMapping(value = "/search-tag-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tag>> searchTagAll(@RequestBody TagSearchDto tagSearchDto) {
        return ResponseEntity.ok(tagService.searchTagAll(tagSearchDto));
    }

    @PostMapping(value = "/search-tag",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Tag>> searchTag(@RequestBody TagSearchDto tagSearchDto, Pageable pageable) {
        return ResponseEntity.ok(tagService.searchTag(tagSearchDto, pageable));
    }
}
