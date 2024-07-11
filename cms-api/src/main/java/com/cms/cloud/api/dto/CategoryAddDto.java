package com.cms.cloud.api.dto;

import com.cms.cloud.api.validation.UniqueCategoryName;
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
public class CategoryAddDto {

    @NotNull
    @UniqueCategoryName
    private String name;

    @NotEmpty
    @NotBlank
    private String description;
}
