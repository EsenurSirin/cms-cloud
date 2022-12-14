package com.cms.cloud.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchDto {

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String password;

    private String telephone;

    private Date dateOfBirth;
}
