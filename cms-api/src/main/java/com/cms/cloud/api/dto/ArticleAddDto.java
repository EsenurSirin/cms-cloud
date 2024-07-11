package com.cms.cloud.api.dto;

import com.cms.cloud.api.validation.UniqueArticleName;
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
public class ArticleAddDto {

    @NotEmpty
    private String userId;

    @NotEmpty
    private String categoryId;

    @NotEmpty
    @NotBlank
    @UniqueArticleName
    private String title;

    @NotEmpty
    @NotBlank
    private String content;
}
