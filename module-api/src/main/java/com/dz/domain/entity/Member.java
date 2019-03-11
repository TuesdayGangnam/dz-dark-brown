package com.dz.domain.entity;

import com.dz.domain.dto.MemberDto;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Member {

    @Id
    @GeneratedValue
    private long memberId;

    @Column(nullable = false)
    @JsonProperty
    private String id;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    @JsonProperty
    private String sex;

    @Column(name="birth_day", nullable = false)
    @JsonProperty
    private String birthDay;

    @Column(nullable = false)
    @JsonProperty
    private String nickname;

    @Column(nullable = false)
    @JsonProperty
    private String location;

    @Column(name="location_detail", nullable = false)
    @JsonProperty
    private String locationDetail;

    @Column(nullable = false)
    @JsonProperty
    private String height;

    @Column(name="body_type", nullable = false)
    @JsonProperty
    private String bodyType;

    @Column(name="education_background", nullable = false)
    @JsonProperty
    private String educationBackground;

    @Column(nullable = false)
    @JsonProperty
    private String job;

    @Column(name="job_detail", nullable = false)
    @JsonProperty
    private String jobDetail;

    @Column(nullable = false)
    @JsonProperty
    private String religion;

    @Column(name="drink_yn", nullable = false)
    @JsonProperty
    private String drinkYn;

    @Column(name="smoke_yn", nullable = false)
    @JsonProperty
    private String smokeYn;

    @Column(name="profile_photo_id", nullable = false)
    @JsonProperty
    private String profilePhotoId;

    @Column(nullable = false)
    @JsonProperty
    private String tier;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "updated_time")
    private LocalDateTime updatedTime;

    public MemberDto toEntity(){
        return MemberDto
                .builder()
                .id(id)
                .password(password)
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
