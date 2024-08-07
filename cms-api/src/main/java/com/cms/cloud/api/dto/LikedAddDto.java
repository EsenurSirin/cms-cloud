package com.cms.cloud.api.dto;

import com.cms.cloud.api.validation.UniqueLiked;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@UniqueLiked
public class LikedAddDto {

    @NotEmpty
    private String articleId;

    @NotEmpty
    private String userId;
}
