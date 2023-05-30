package com.elebite.mvc.mapper;

import com.elebite.mvc.dto.UserEntityDto;
import com.elebite.mvc.models.UserEntity;

public class UserEntityMapper {

    public static UserEntity mapToUserEntity(UserEntityDto userEntityDto) {
        UserEntity userEntity = UserEntity.builder()
                .id(userEntityDto.getId())
                .username(userEntityDto.getUsername())
                .email(userEntityDto.getEmail())
                .password(userEntityDto.getPassword())
                .memberName(userEntityDto.getMemberName())
                .memberPhone(userEntityDto.getMemberPhone())
                .memberPosition(userEntityDto.getMemberPosition())
                .memberAffiliationType(userEntityDto.getMemberAffiliationType())
                .memberOther(userEntityDto.getMemberOther())
                .memberEducationDescription(userEntityDto.getMemberEducationDescription())
                .memberEducationRating(userEntityDto.getMemberEducationRating())
                .memberWorkExperienceDescription(userEntityDto.getMemberWorkExperienceDescription())
                .memberWorkExperienceRating(userEntityDto.getMemberWorkExperienceRating())
                .memberTechnicalSkillDescription(userEntityDto.getMemberTechnicalSkillDescription())
                .memberTechnicalSkillRating(userEntityDto.getMemberTechnicalSkillRating())
                .memberScrumExperienceDescription(userEntityDto.getMemberScrumExperienceDescription())
                .memberScrumExperienceRating(userEntityDto.getMemberScrumExperienceRating())
                .memberSoftSkillDescription(userEntityDto.getMemberSoftSkillDescription())
                .memberSoftSkillRating(userEntityDto.getMemberSoftSkillRating())
                .memberAreasOfInterestDescription(userEntityDto.getMemberAreasOfInterestDescription())
                .memberAreasOfInterestRating(userEntityDto.getMemberAreasOfInterestRating())
                .build();
        return userEntity;
    }

    public static UserEntityDto mapToUserEntityDto(UserEntity userEntity) {
        UserEntityDto userEntityDto = UserEntityDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .memberName(userEntity.getMemberName())
                .memberPhone(userEntity.getMemberPhone())
                .memberPosition(userEntity.getMemberPosition())
                .memberAffiliationType(userEntity.getMemberAffiliationType())
                .memberOther(userEntity.getMemberOther())
                .memberEducationDescription(userEntity.getMemberEducationDescription())
                .memberEducationRating(userEntity.getMemberEducationRating())
                .memberWorkExperienceDescription(userEntity.getMemberWorkExperienceDescription())
                .memberWorkExperienceRating(userEntity.getMemberWorkExperienceRating())
                .memberTechnicalSkillDescription(userEntity.getMemberTechnicalSkillDescription())
                .memberTechnicalSkillRating(userEntity.getMemberTechnicalSkillRating())
                .memberScrumExperienceDescription(userEntity.getMemberScrumExperienceDescription())
                .memberScrumExperienceRating(userEntity.getMemberScrumExperienceRating())
                .memberSoftSkillDescription(userEntity.getMemberSoftSkillDescription())
                .memberSoftSkillRating(userEntity.getMemberSoftSkillRating())
                .memberAreasOfInterestDescription(userEntity.getMemberAreasOfInterestDescription())
                .memberAreasOfInterestRating(userEntity.getMemberAreasOfInterestRating())
                .build();
        return userEntityDto;
    }
}

