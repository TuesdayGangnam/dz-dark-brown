package com.dz.web.service.impl;

import com.dz.domain.dto.request.MemberResponseDto;
import com.dz.domain.entity.Member;
import com.dz.domain.repository.MemberRepository;
import com.dz.web.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.dz.constant.ResponseCode.NOT_FOUND_DATA;
import static com.dz.exceptions.LogicExcepion.internalException;

@Service("MemberService")
@AllArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public Member update(Member member) {
        return memberRepository.save(member);
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }

    public Optional<Member> findByUserId(long id) {
        return memberRepository.findByMemberId(id);
    }

    @Transactional(readOnly = true)
    public Map<String, MemberResponseDto> getMember(long memberId) {

        Optional<Member> memberOptional = memberRepository.findByMemberId(memberId);

        if (!memberOptional.isPresent()){
            throw internalException(NOT_FOUND_DATA);
        }

        Map<String, MemberResponseDto> resultMap = new HashMap<>();
        resultMap.put("member", memberOptional.get().toResponseDto());

        return resultMap;

    }




}
