package com.dz.domain.member;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Created by yong on 2018. 11. 18..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    public void 게시글저장_불러오기() {

    }

    @Test
    public void BaseTimeEntity_등록 () {
        //given
        LocalDateTime now = LocalDateTime.now();
        memberRepository.save(Member.builder()
                .id("테스트 게시글")
                .name("테스트 본문")
                .password("test")
                .phone("01041797900")
                .build());
        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Member member = memberList.get(0);
//        assertTrue(member.getNo() > 1);
        System.out.println("1 ===== " + member.getCreatedTime());
        System.out.println("2 ===== " + member.getLastConnectedTime());
        System.out.println("3 ===== " + member.getTesttime());
//        assertTrue(member.getCreatedTime().isAfter(now));
//        assertTrue(member.getLastConnectedTime().isAfter(now));
    }
}