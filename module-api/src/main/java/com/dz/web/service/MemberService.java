package com.dz.web.service;

import com.dz.domain.dto.request.MemberResponseDto;
import com.dz.domain.entity.Member;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberService {

    List<Member> findAll();

    Member create(Member member);

    Member update(Member member);

    void delete(Member member);

    Optional<Member> findByUserId(long id);

    Map<String, MemberResponseDto> getMember(long memberId);
}
