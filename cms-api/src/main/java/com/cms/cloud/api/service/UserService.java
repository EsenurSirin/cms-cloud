package com.cms.cloud.api.service;

import com.cms.cloud.api.dto.UserAddDto;
import com.cms.cloud.api.dto.UserSearchDto;
import com.cms.cloud.api.dto.UserUpdateDto;
import com.cms.cloud.dao.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User addUser(UserAddDto userAddDto);

    void deleteUser(String userGuid);

    User updateUser(UserUpdateDto userUpdateDto);

    List<User> getAllUser();

    List<User> searchUserAll(UserSearchDto userSearchDto);

    Page<User> searchUser(UserSearchDto userSearchDto, Pageable pageable);
}
