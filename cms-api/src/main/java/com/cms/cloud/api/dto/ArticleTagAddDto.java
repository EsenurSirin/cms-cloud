package com.cms.cloud.api.dto;

//import com.cms.cloud.api.validation.UniqueArticleTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@UniqueArticleTag
public class ArticleTagAddDto {

    @NotEmpty
    private String articleId;

    @NotEmpty
    private String tagId;
}
