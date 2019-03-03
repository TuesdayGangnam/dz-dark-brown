package com.dz.domain.dto;

import com.dz.domain.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private long memberId;

    @NotNull
    private String sex;

    public MemberEntity toEntity(long memberId){
        return MemberEntity
                .builder()
                .memberId(memberId)
                .build();
    }
}
