package com.dz.controller;


import com.dz.ApiApplication;
import com.dz.domain.dto.MemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@Transactional
public class BaseController {


    @Autowired
    protected MockMvc mockMvc;

    MemberDto normalMember;

    @Before
    public void init(){
        normalMember = MemberDto.builder()
                .memberId(1)
                .id("yongjin")
                .password("1234")
                .sex("male")
                .birthDay("19890210")
                .nickname("용용이")
                .location("서울")
                .locationDetail("관악구 봉천동")
                .height("183")
                .bodyType("일반")
                .educationBackground("4년제")
                .job("직장인")
                .jobDetail("소프트웨어 엔지니어")
                .religion("없음")
                .drinkYn("Y")
                .smokeYn("N")
                .profilePhotoId(1)
                .tier("5.47")
                .build();
    }


    protected String convertObjectToJsonString(Object object) throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writerWithDefaultPrettyPrinter();
        return writer.writeValueAsString(object);
    }


}
