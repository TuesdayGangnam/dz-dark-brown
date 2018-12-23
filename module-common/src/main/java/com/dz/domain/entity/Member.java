package com.dz.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberName;

}
