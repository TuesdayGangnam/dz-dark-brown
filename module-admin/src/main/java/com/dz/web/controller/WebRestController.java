package com.dz.web.controller;

import com.dz.domain.dto.MemberRepository;
import com.dz.domain.dto.MemberSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yong on 2018. 10. 25..
 */
@RestController
@AllArgsConstructor
public class WebRestController {

    private MemberRepository memberRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld1122445533";
    }

    @PostMapping("/member")
    public void savePosts(@RequestBody MemberSaveRequestDto dto){
        memberRepository.save(dto.toEntity());
    }
}