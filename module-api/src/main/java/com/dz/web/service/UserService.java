package com.dz.web.service;

import com.dz.domain.dto.UserDto;
import com.dz.domain.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(UserDto userDto);

    void delete(Long id);

}
