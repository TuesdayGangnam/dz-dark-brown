package com.dz.controller;

import com.dz.ApiApplication;
import com.dz.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void 멤버조회_정상케이스() throws Exception {

        //given
        MemberDto memberDto = MemberDto.builder()
                .memberId(1234)
                .build();

        this.mockMvc.perform(get("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("memberId", "1234"))
                .andDo(print())
                .andExpect(jsonPath("code").exists())
                .andExpect(jsonPath("results").exists())
                .andExpect(jsonPath("results[0].memberId").value(is(1234)))
        ;
    }

    @Test
    public void 멤버조회_실퍠_검색조건_성별_없는경우() throws Exception {

        //given
        MemberDto memberDto = MemberDto.builder()
                .memberId(1234)
                .build();

        this.mockMvc.perform(get("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("memberId", "1234")
        )
                .andDo(print())
                .andExpect(jsonPath("code").value(is("401")))

        ;
    }

    @Test
    public void 멤버생성() {

    }

    @Test
    public void 멤버수정() {

    }

    @Test
    public void 멤버삭제() {

    }

}
