package com.dz.service;

import com.dz.ApiApplication;
import com.dz.domain.entity.Member;
import com.dz.domain.entity.User;
import com.dz.web.service.UserService;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userServiceImpl;

    @Test
    public void MemberService_common_의존성테스트(){


        List<User> users = userServiceImpl.findAll();

        assertThat(users.get(0).getUsername(), is("jihoon"));

    }

}
