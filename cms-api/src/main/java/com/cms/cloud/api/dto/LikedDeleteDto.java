package com.cms.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikedDeleteDto {

    @NotEmpty
    private String articleId;

    @NotEmpty
    private String userId;
}
