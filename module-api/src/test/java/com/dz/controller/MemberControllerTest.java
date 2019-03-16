package com.dz.controller;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class MemberControllerTest extends BaseController {

    @Test
    public void 멤버리스트조회_정상케이스() throws Exception {

        this.mockMvc.perform(get("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .param("memberId", "1234")
                .param("sex", "male"))
                .andDo(print())
                .andExpect(jsonPath("code").exists())
                .andExpect(jsonPath("results").exists())
                .andExpect(jsonPath("results[0].memberId").value(is(1234)))
        ;
    }

    @Test
    public void 멤버조회_실퍠_검색조건_성별_없는경우() throws Exception {

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
    public void 멤버조회_정상케이스() throws Exception{

        this.mockMvc.perform(get("/api/v1/members/{member_id}", 1L)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("code").value("200"))
                .andExpect(jsonPath("$.results.member.id").value("yongjin"))
        ;
    }

    @Test
    public void 멤버생성_정상케이스()  throws Exception{

        String requestJson = convertObjectToJsonString(normalMember);

        this.mockMvc.perform(post("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content( requestJson))
                .andDo(print())
                .andExpect(jsonPath("code").value("200"))
        ;
    }

    @Test
    public void 멤버생성후_조회_정상케이스() throws Exception {
        멤버생성_정상케이스();
        멤버조회_정상케이스();
    }

    @Test
    public void 멤버수정() {

    }

    @Test
    public void 멤버삭제() {

    }

}
