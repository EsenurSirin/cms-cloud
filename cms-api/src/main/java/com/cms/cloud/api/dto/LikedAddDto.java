package com.cms.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@UniqueLiked
public class LikedAddDto {

    @NotEmpty
    private String articleId;

    @NotEmpty
    private String userId;
}
