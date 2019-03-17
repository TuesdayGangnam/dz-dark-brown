package com.dz.controller;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class MemberControllerTest extends BaseControllerTest {

    @Test
    public void 멤버리스트조회_정상케이스() throws Exception {

        this.mockMvc.perform(get("/api/v1/members")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(jsonPath("code").exists())
                .andExpect(jsonPath("results").exists())
                .andExpect(jsonPath("results[0].id").value(is("yongjin")))
        ;
    }

    @Test
    public void 멤버조회_정상케이스() throws Exception{

        this.mockMvc.perform(get("/api/v1/members/{member_id}", 1L)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("code").value("200"))
        ;
    }

    @Test
    public void 멤버조회_에러케이스_멤버아이디가_없을경우() throws Exception{

        this.mockMvc.perform(get("/api/v1/members/{member_id}", 2L)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(jsonPath("code").value("609"))
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
    public void 멤버수정_정상케이스() throws Exception{

        String requestJson = convertObjectToJsonString(updatedMember);

        this.mockMvc.perform(put("/api/v1/members/{member_id}", 1L)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andDo(print())
                .andExpect(jsonPath("code").value("200"))
        ;
    }

    @Test
    public void 멤버삭제_정상케이스() throws Exception{
        String requestJson = convertObjectToJsonString(updatedMember);

        this.mockMvc.perform(delete("/api/v1/members/{member_id}", 1L)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andDo(print())
                .andExpect(jsonPath("code").value("609"))
        ;
    }

    @Test
    public void 멤버생성후_조회_정상케이스() throws Exception {
        멤버생성_정상케이스();
        멤버조회_정상케이스();
    }

    @Test
    public void 멤버생성후_조회_에러케이스() throws Exception {
        멤버생성_정상케이스();
        멤버조회_에러케이스_멤버아이디가_없을경우();
    }


    @Test
    public void 멤버생성후_멤버리스트조회_정상케이스() throws Exception {
        멤버생성_정상케이스();
        멤버리스트조회_정상케이스();
    }

    @Test
    public void 멤버생성후_멤버수정_정상케이스() throws Exception {
        멤버생성_정상케이스();
        멤버수정_정상케이스();
        멤버조회_정상케이스();
    }

    @Test
    public void 멤버생성후_멤버삭제_정상케이스() throws Exception {
        멤버생성_정상케이스();
        멤버삭제_정상케이스();
        멤버조회_정상케이스();
    }

}
