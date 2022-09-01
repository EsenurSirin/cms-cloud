package com.cms.cloud.api.controller;

import com.cms.cloud.api.service.ArticleTagService;
import com.cms.cloud.api.dto.ArticleTagAddDto;
import com.cms.cloud.api.dto.ArticleTagSearchDto;
import com.cms.cloud.api.dto.ArticleTagUpdateDto;
import com.cms.cloud.dao.entities.ArticleTag;
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
@RequestMapping("/api/articletag")
public class ArticleTagController {

    @Autowired
    ArticleTagService articleTagService;

    @PostMapping("/add-articletag")

    public ResponseEntity add(@RequestBody @Valid ArticleTagAddDto articleTagAddDto) {
        articleTagService.addArticleTag(articleTagAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update-articletag")
    public ResponseEntity update(@RequestBody @Valid ArticleTagUpdateDto articleTagUpdateDto) {
        articleTagService.updateArticleTag(articleTagUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-articletag")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty String id) {
        articleTagService.deleteArticleTag(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/list-articletag")
    public ResponseEntity<List<ArticleTag>> getAll() {
        return ResponseEntity.ok(articleTagService.getAllArticleTag());
    }

    @PostMapping(value = "/search-articletag-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArticleTag>> searchArticleTagAll(@RequestBody ArticleTagSearchDto articleTagSearchDto) {
        return ResponseEntity.ok(articleTagService.searchArticleTagAll(articleTagSearchDto));
    }

    @PostMapping(value = "/search-articletag",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ArticleTag>> searchArticleTag(@RequestBody ArticleTagSearchDto articleTagSearchDto, Pageable pageable) {
        return ResponseEntity.ok(articleTagService.searchArticleTag(articleTagSearchDto, pageable));
    }
}
