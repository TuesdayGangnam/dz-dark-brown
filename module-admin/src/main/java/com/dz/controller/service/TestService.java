package com.dz.controller.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    public void testMethod(){
        log.error("error : {}", "1123123123123123123123123");
    }

}
