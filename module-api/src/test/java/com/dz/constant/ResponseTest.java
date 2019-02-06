package com.dz.constant;

import com.dz.ApiApplication;
import com.dz.exceptions.LogicExcepion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.NestedServletException;

import static com.dz.constant.ResponseAttribute.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class, webEnvironment = RANDOM_PORT)
public class ResponseTest {

    @Autowired
    private WebApplicationContext webContext;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).addFilter(springSecurityFilterChain).build();
    }


    @Test
    public void response값_확인() {
        String abc = "";
        System.out.println(abc.isEmpty());

        log.debug("SERVER_CODE : {}", SERVER_CODE.getResponseKey());
        log.debug("SERVER_MESSAGE : {}", SERVER_MESSAGE.getResponseKey());
        log.debug("RESULTS : {}", RESULTS.getResponseKey());

        assertThat(SERVER_CODE.getResponseKey(), is("code"));
        assertThat(SERVER_MESSAGE.getResponseKey(), is("message"));
        assertThat(RESULTS.getResponseKey(), is("results"));
    }

    @Test
    public void API통신_성공_테스트() throws Exception {

        String accessToken = obtainAccessToken();

        log.error("accessToken {}", accessToken);


        this.mockMvc.perform(get("/sample/success")
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }


    @Test
    public void API통신_실패_테스트() throws Exception {

        String accessToken = obtainAccessToken();

        this.mockMvc.perform(get("/sample/fail")
                .header("Authorization", "Bearer " + accessToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

    public String obtainAccessToken() throws Exception {

        ResultActions result
                = mockMvc.perform(post("/oauth/token")
                .header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "jihoon")
                .param("password", "pass")
                .param("grant_type", "password")
                .with(httpBasic("test", "1234")))
                .andDo(print())
                .andExpect(status().isOk());

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }


}
