package com.dz.domain.entity;

import com.dz.domain.dto.request.MemberResponseDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private long memberId;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String sex;

    @Column(name="birth_day", nullable = false)
    private String birthDay;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String location;

    @Column(name="location_detail", nullable = false)
    private String locationDetail;

    @Column(nullable = false)
    private String height;

    @Column(name="body_type", nullable = false)
    private String bodyType;

    @Column(name="education_background", nullable = false)
    private String educationBackground;

    @Column(nullable = false)
    private String job;

    @Column(name="job_detail", nullable = false)
    private String jobDetail;

    @Column(nullable = false)
    private String religion;

    @Column(name="drink_yn", nullable = false)
    private String drinkYn;

    @Column(name="smoke_yn", nullable = false)
    private String smokeYn;

    @Column(name="profile_photo_id", nullable = false)
    private long profilePhotoId;

    @Column(nullable = false)
    private String tier;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    public MemberResponseDto toResponseDto(){
        return MemberResponseDto
                .builder()
                .memberId(memberId)
                .id(id)
                .sex(sex)
                .birthDay(birthDay)
                .nickname(nickname)
                .location(location)
                .locationDetail(locationDetail)
                .height(height)
                .bodyType(bodyType)
                .educationBackground(educationBackground)
                .job(job)
                .jobDetail(jobDetail)
                .religion(religion)
                .drinkYn(drinkYn)
                .smokeYn(smokeYn)
                .profilePhotoId(profilePhotoId)
                .tier(tier)
                .createdTime(createdTime)
                .build();
    }
}
