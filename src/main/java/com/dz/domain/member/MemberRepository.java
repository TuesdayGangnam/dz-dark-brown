package com.dz.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yong on 2018. 11. 17..
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
}
