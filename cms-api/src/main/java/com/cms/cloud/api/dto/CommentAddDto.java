package com.cms.cloud.api.dto;

//import com.cms.cloud.api.validation.UniqueComment;

import com.cms.cloud.api.validation.UniqueComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@UniqueComment
public class CommentAddDto {

    @NotEmpty
    private String articleId;

    @NotNull
    private String userId;

    @NotEmpty
    @NotBlank
    private String content;
}
