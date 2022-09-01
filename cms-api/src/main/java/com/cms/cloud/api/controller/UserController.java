package com.cms.cloud.api.controller;

import com.cms.cloud.api.aop.Log;
import com.cms.cloud.api.aop.LogType;
import com.cms.cloud.api.service.UserService;
import com.cms.cloud.api.dto.UserAddDto;
import com.cms.cloud.api.dto.UserSearchDto;
import com.cms.cloud.api.dto.UserUpdateDto;
import com.cms.cloud.dao.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity add(@RequestBody @Valid UserAddDto userAddDto) {
        userService.addUser(userAddDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity delete(@RequestBody @Valid @NotEmpty String id) {
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/update-user")
    public ResponseEntity update(@RequestBody @Valid UserUpdateDto userUpdateDto) {
        userService.updateUser(userUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/list-user")
    @Log(LogType.READ)
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping(value = "/search-user-all",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> searchUserAll(@RequestBody UserSearchDto userSearchDto) {
        return ResponseEntity.ok(userService.searchUserAll(userSearchDto));
    }

    @PostMapping(value = "/search-user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<User>> searchUser(@RequestBody UserSearchDto userSearchDto, Pageable pageable) {
        return ResponseEntity.ok(userService.searchUser(userSearchDto, pageable));
    }
}
