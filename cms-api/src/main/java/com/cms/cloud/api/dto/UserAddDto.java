package com.cms.cloud.api.dto;

import lombok.*;

import jakarta.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAddDto {

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private String userName;

    @Email
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    @Size
    private String telephone;

    @PastOrPresent
    private Date dateOfBirth;
}
