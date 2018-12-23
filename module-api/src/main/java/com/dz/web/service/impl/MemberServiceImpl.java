package com.dz.web.service.impl;

import com.dz.domain.entity.Member;
import com.dz.domain.repository.MemberRepository;
import com.dz.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @PostConstruct
    public void saveMember(){
        Member member = new Member();
        member.setMemberName("jihoon");
        memberRepository.save(member);
    }

    public List<Member> getMemberList() {
        return memberRepository.findAll();

    }
}
