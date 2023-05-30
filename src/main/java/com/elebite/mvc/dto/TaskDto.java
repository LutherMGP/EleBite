package com.elebite.mvc.dto;


import com.elebite.mvc.models.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long taskID;
    @NotEmpty(message = "Project name should not be empty")
    private String taskName;
    private String taskDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskStartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskEndDate;
    private String taskCreator;
    private LocalDateTime taskCreatedDateTime;
    private LocalDateTime taskUpdatedDateTime;
    private String taskUpdatedCreator;
    private Long taskTeamID;
    private Double taskEstimatedHours;
    private String taskStatus;
    private Project project;
}
