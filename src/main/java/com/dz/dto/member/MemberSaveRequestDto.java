package com.dz.dto.member;

import com.dz.domain.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by yong on 2018. 11. 18..
 */
@Getter
@Setter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String id;
    private String password;
    private String name;
    private String phone;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .password(password)
                .name(name)
                .phone(phone).build();

    }
}
