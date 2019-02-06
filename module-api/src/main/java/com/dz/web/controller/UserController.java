package com.dz.web.controller;

import com.dz.domain.dto.UserDto;
import com.dz.domain.entity.User;
import com.dz.web.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public String UserTest() {
        return "user test";
    }

    @GetMapping("/user")
    public List<User> listUser() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "success";

    }
}
