package com.dz.web.service.impl;

import com.dz.domain.entity.Member;
import com.dz.domain.repository.MemberRepository;
import com.dz.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service("MemberService")
@AllArgsConstructor
public class MembersServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Transactional(readOnly = true)
    @Override
    public List findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    @Override
    public Member create(Member member) {
        return memberRepository.save(member);

    }

    @Transactional
    @Override
    public Member update(Member member) {
        return memberRepository.save(member);
    }

    @Transactional
    @Override
    public void delete(Member member) {
        memberRepository.delete(member);
    }

    @Transactional
    @Override
    public Member findByUserId(long id) {
        return memberRepository.findByMemberId(id);
    }
}
