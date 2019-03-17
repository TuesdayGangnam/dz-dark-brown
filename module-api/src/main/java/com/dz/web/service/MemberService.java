package com.dz.web.service;

import com.dz.domain.entity.Member;
import java.util.List;
import java.util.Optional;

public interface MemberService {

    List findAll();

    Member create(Member member);

    Member update(Member member);

    void delete(Member member);

    Optional<Member> findByUserId(long id);
}
