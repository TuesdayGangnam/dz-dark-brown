package com.dz.domain.dto;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by yong on 2018. 11. 17..
 */
@Component
public interface MemberRepository extends JpaRepository<Member, Long> {
}
