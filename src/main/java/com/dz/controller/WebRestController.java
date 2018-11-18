package com.dz.controller;

import com.dz.domain.member.MemberRepository;
import com.dz.dto.member.MemberSaveRequestDto;
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
        return "HelloWorld";
    }

    @PostMapping("/member")
    public void savePosts(@RequestBody MemberSaveRequestDto dto){
        memberRepository.save(dto.toEntity());
    }
}