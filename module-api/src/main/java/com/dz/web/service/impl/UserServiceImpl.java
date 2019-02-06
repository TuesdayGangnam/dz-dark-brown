package com.dz.web.service.impl;

import com.dz.domain.dto.UserDto;
import com.dz.domain.entity.User;
import com.dz.domain.repository.UserRepository;
import com.dz.web.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@Validated
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        User jihoon = userRepository.findByUsername("jihoon");
        if (jihoon == null) {
            UserDto userDto = new UserDto();
            userDto.setUsername("jihoon");
            userDto.setPassword("pass");
            userDto.setRole("ROLE_USER");
            User newUser = this.save(userDto);
            log.info("new User : {}", newUser);
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(userDto.toEntity());
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthroities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthroities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }


}
