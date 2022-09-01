package com.cms.cloud.api.controller;

import com.cms.cloud.api.service.CommentService;
import com.cms.cloud.api.dto.CommentAddDto;
import com.cms.cloud.api.dto.CommentSearchDto;
import com.cms.cloud.api.dto.CommentUpdateDto;
import com.cms.cloud.dao.entities.Comment;
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
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/add-comment")
    public ResponseEntity add(@RequestBody @Valid CommentAddDto commentAddDto) {
        commentService.addComment(commentAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update-comment")
    public ResponseEntity update(@RequestBody @Valid CommentUpdateDto commentUpdateDto) {
        commentService.updateComment(commentUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-comment")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty String id) {
        commentService.deleteComment(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list-comment")
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentService.getAllComment());
    }

    @PostMapping(value = "/search-comment-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Comment>> searchCommentAll(@RequestBody CommentSearchDto commentSearchDto) {
        return ResponseEntity.ok(commentService.searchCommentAll(commentSearchDto));
    }

    @PostMapping(value = "/search-comment",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Comment>> searchComment(@RequestBody CommentSearchDto commentSearchDto, Pageable pageable) {
        return ResponseEntity.ok(commentService.searchComment(commentSearchDto, pageable));
    }
}
