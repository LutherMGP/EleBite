package com.elebite.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityDto {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private String memberName;
    private String memberPhone;
    private String memberPosition;
    private int memberAffiliationType;
    private String memberOther;
    private String memberEducationDescription;
    private int memberEducationRating;
    private String memberWorkExperienceDescription;
    private int memberWorkExperienceRating;
    private String memberTechnicalSkillDescription;
    private int memberTechnicalSkillRating;
    private String memberScrumExperienceDescription;
    private int memberScrumExperienceRating;
    private String memberSoftSkillDescription;
    private int memberSoftSkillRating;
    private String memberAreasOfInterestDescription;
    private int memberAreasOfInterestRating;
}
