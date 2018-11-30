package com.dz;

import com.dz.controller.WebRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ModuleApiApplication.class})
public class ModuleTest {




    @Autowired
    ComponentTest componentTest;
    //test
    @Autowired
    WebRestController webRestController123;

    @Test
    public void 의존성테스트(){



        //WebRestController webRestController = new WebRestController();
        log.info("hello : {}", webRestController123.test());

    }
}
