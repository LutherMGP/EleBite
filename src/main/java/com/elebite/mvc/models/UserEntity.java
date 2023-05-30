package com.elebite.mvc.models;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @Column (name = "member_name")
    private String memberName;
    @Column (name = "member_phone")
    private String memberPhone;
    @Column (name = "member_position")
    private String memberPosition;
    @Column (name = "member_affiliation_type")
    private int memberAffiliationType;
    @Column (name = "member_other")
    private String memberOther;
    @Column (name = "member_education_description")
    private String memberEducationDescription;
    @Column (name = "member_education_rating")
    private int memberEducationRating;
    @Column (name = "member_work_experience_description")
    private String memberWorkExperienceDescription;
    @Column (name = "member_work_experience_rating")
    private int memberWorkExperienceRating;
    @Column (name = "member_technical_skill_description")
    private String memberTechnicalSkillDescription;
    @Column (name = "member_technical_skill_rating")
    private int memberTechnicalSkillRating;
    @Column (name = "member_scrum_experience_description")
    private String memberScrumExperienceDescription;
    @Column (name = "member_scrum_experience_rating")
    private int memberScrumExperienceRating;
    @Column (name = "member_soft_skill_description")
    private String memberSoftSkillDescription;
    @Column (name = "member_soft_skill_rating")
    private int memberSoftSkillRating;
    @Column (name = "member_areas_of_interest_description")
    private String memberAreasOfInterestDescription;
    @Column (name = "member_areas_of_interest_rating")
    private int memberAreasOfInterestRating;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();
}
