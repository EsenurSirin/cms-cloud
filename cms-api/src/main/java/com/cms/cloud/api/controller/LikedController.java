package com.cms.cloud.api.controller;

import com.cms.cloud.api.service.LikedService;
import com.cms.cloud.api.dto.LikedAddDto;
import com.cms.cloud.api.dto.LikedDeleteDto;
import com.cms.cloud.api.dto.LikedSearchDto;
import com.cms.cloud.dao.entities.Liked;
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
@RequestMapping("/api/liked")
public class LikedController {

    @Autowired
    LikedService likedService;

    @PostMapping("/add-liked")
    public ResponseEntity add(@RequestBody @Valid LikedAddDto likedAddDto) {
        likedService.addLiked(likedAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-liked")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty LikedDeleteDto likedDeleteDto) {
        likedService.deleteLiked(likedDeleteDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list-liked")
    public ResponseEntity<List<Liked>> getAll() {
        return ResponseEntity.ok(likedService.getAllLiked());
    }

    @PostMapping(value = "/search-liked-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Liked>> searchLikedAll(@RequestBody LikedSearchDto likedSearchDto) {
        return ResponseEntity.ok(likedService.searchLikedAll(likedSearchDto));
    }

    @PostMapping(value = "/search-liked",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Liked>> searchLiked(@RequestBody LikedSearchDto likedSearchDto, Pageable pageable) {
        return ResponseEntity.ok(likedService.searchLiked(likedSearchDto, pageable));
    }
}
