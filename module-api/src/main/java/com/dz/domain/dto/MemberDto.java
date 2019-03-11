package com.dz.domain.dto;

import com.dz.domain.entity.Member;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberDto {

    @NotNull
    @Id
    private long memberId;

    @NotNull
    private String id;

    @NotNull
    private String password;

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
    private String profilePhotoId;

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
