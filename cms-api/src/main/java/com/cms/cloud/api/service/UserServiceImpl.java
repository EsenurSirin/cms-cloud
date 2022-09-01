package com.cms.cloud.api.service;

import com.cms.cloud.api.spec.UserSpecification;
import com.cms.cloud.api.dto.UserAddDto;
import com.cms.cloud.api.dto.UserSearchDto;
import com.cms.cloud.api.dto.UserUpdateDto;
import com.cms.cloud.dao.entities.User;
import com.cms.cloud.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@EnableJpaRepositories(basePackages = {"com.cms.cloud.dao.repository"})
@EntityScan("com.cms.cloud.dao.entities")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(UserAddDto userAddDto) {

        User user = new User();
        user.setFirstName(userAddDto.getFirstName());
        user.setLastName(userAddDto.getLastName());
        user.setUserName(userAddDto.getUserName());
        user.setEmail(userAddDto.getEmail());
        user.setPassword(userAddDto.getPassword());
        user.setTelephone(userAddDto.getTelephone());
        user.setDateOfBirth(new Date());
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userGuid) {

        userRepository.delete(userRepository.findById(userGuid).orElseThrow());
    }

    @Override
    public User updateUser(UserUpdateDto userUpdateDto) {

        User user = userRepository.findById(userUpdateDto.getUserId()).orElseThrow();
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        user.setUserName(userUpdateDto.getUserName());
        user.setEmail(userUpdateDto.getEmail());
        user.setPassword(userUpdateDto.getPassword());
        user.setTelephone(userUpdateDto.getTelephone());
        user.setDateOfBirth(new Date());
        user.setModifiedAt(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> searchUserAll(UserSearchDto userSearchDto) {

        UserSpecification userSpecification = new UserSpecification();
        List<User> userList = userRepository.findAll(Specification.where(userSpecification.search(userSearchDto)));
        return userList;
    }

    @Override
    public Page<User> searchUser(UserSearchDto userSearchDto, Pageable pageable) {

        UserSpecification userSpecification = new UserSpecification();
        Page<User> userList = userRepository.findAll(Specification.where(userSpecification.search(userSearchDto)), pageable);
        return userList;
    }
}
