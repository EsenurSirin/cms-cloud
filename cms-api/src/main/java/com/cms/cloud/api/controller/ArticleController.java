package com.cms.cloud.api.controller;

import com.cms.cloud.api.service.ArticleService;
import com.cms.cloud.api.dto.ArticleAddDto;
import com.cms.cloud.api.dto.ArticleSearchDto;
import com.cms.cloud.api.dto.ArticleUpdateDto;
import com.cms.cloud.dao.entities.Article;
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
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/add-article")
    public ResponseEntity add(@RequestBody @Valid ArticleAddDto articleAddDto) {
        articleService.addArticle(articleAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update-article")
    public ResponseEntity update(@RequestBody @Valid ArticleUpdateDto articleUpdateDto) {
        articleService.updateArticle(articleUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-article")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty String id) {
        articleService.deleteArticle(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list-article")
    public ResponseEntity<List<Article>> getAll() {
        return ResponseEntity.ok(articleService.getAllArticle());
    }

    @PostMapping(value = "/search-article-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Article>> searchArticleAll(@RequestBody ArticleSearchDto articleSearchDto) {
        return ResponseEntity.ok(articleService.searchArticleAll(articleSearchDto));
    }

    @PostMapping(value = "/search-article",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Article>> searchArticle(@RequestBody ArticleSearchDto articleSearchDto, Pageable pageable) {
        return ResponseEntity.ok(articleService.searchArticle(articleSearchDto, pageable));
    }
}
