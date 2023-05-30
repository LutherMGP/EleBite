package com.elebite.mvc.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Data
@Builder
public class ProjectDto {
    private Long projectID;
    @NotEmpty(message = "Project name should not be empty")
    private String projectName;
    private String projectDescription;
    private String projectPhotoUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectEndDate;
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime projectCreatedDateTime;
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime projectUpdatedDateTime;
    private String projectTeamName;
    private Double projectEstimatedHours;
    private String projectStatus;
    private List<TaskDto> tasks;

/*
Denne klasse er en DTO (Data Transfer Object) klasse.
ProjectDto.java-klassen bruges til at overføre og behandle projektdata
i forskellige lag af applikationen eller til eksterne systemer.
Den har ikke nogen JPA-annotationer og er ikke mappet til en database.
Den er kun designet til dataoverførsel.
 */

}