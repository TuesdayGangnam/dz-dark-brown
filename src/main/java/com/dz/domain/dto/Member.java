package com.dz.domain.dto;


import com.dz.domain.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column
    private String id;

    @Column
    private String password;

    @Column
    private String name;

    @Type(type = "char")
    private String gender;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    @Type(type = "char")
    private String use_yn;

    @Builder
    public Member(String id, String password, String name, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
}

enum Gender{
    MEN,
    WOMEN
}