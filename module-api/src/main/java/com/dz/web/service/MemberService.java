package com.dz.web.service;

import com.dz.domain.entity.Member;
import java.util.List;

public interface MemberService {

    List findAll();

    Member create(Member member);

    Member update(Member member);

    void delete(Member member);

    Member findByUserId(long id);
}
