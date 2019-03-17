package com.dz.domain.dto.request;

import com.dz.domain.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberResponseDto {

    @NotNull
    @Id
    @JsonProperty("member_id")
    private long memberId;

    @NotNull
    private String id;

    @NotNull
    private String sex;

    @NotNull
    @JsonProperty("birth_day")
    private String birthDay;

    @NotNull
    private String nickname;

    @NotNull
    private String location;

    @NotNull
    @JsonProperty("location_detail")
    private String locationDetail;

    @NotNull
    private String height;

    @NotNull
    @JsonProperty("body_type")
    private String bodyType;

    @NotNull
    @JsonProperty("education_background")
    private String educationBackground;

    @NotNull
    private String job;

    @NotNull
    @JsonProperty("job_detail")
    private String jobDetail;

    @NotNull
    private String religion;

    @NotNull
    @JsonProperty("drink_yn")
    private String drinkYn;

    @NotNull
    @JsonProperty("smoke_yn")
    private String smokeYn;

    @NotNull
    @JsonProperty("profile_photo_id")
    private long profilePhotoId;

    @NotNull
    private String tier;

    @JsonProperty("created_time")
    private LocalDateTime createdTime;

    @JsonProperty("updated_time")
    private LocalDateTime updatedTime;

    public Member toEntity(){
        return Member
                .builder()
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
                .build();
    }
}
