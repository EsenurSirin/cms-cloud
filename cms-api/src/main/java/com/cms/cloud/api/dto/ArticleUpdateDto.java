package com.cms.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateDto {

    @NotEmpty
    private String articleId;

    @NotEmpty
    private String userId;

    @NotEmpty
    private String categoryId;

    @NotEmpty
    @NotBlank
    private String title;

    @NotEmpty
    @NotBlank
    private String content;
}
