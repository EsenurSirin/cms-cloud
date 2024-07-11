package com.cms.cloud.api.controller;

import com.cms.cloud.api.service.CategoryService;
import com.cms.cloud.api.dto.CategoryAddDto;
import com.cms.cloud.api.dto.CategorySearchDto;
import com.cms.cloud.api.dto.CategoryUpdateDto;
import com.cms.cloud.dao.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add-category")
    public ResponseEntity add(@RequestBody @Valid CategoryAddDto categoryAddDto) {

        categoryService.addCategory(categoryAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-category")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty String id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update-category")
    public ResponseEntity update(@RequestBody @Valid CategoryUpdateDto categoryUpdateDto) {
        categoryService.updateCategory(categoryUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list-category")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PostMapping(value = "/search-category-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> searchCategoryAll(@RequestBody CategorySearchDto categorySearchDto) {
        return ResponseEntity.ok(categoryService.searchCategoryAll(categorySearchDto));
    }

    @PostMapping(value = "/search-category",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Category>> searchCategory(@RequestBody CategorySearchDto categorySearchDto, Pageable pageable) {
        return ResponseEntity.ok(categoryService.searchCategory(categorySearchDto, pageable));
    }
}
