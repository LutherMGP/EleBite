package com.elebite.mvc.mapper;

import com.elebite.mvc.dto.ProjectDto;
import com.elebite.mvc.models.Project;

import java.util.stream.Collectors;

import static com.elebite.mvc.mapper.TaskMapper.mapToTaskDto;

public class ProjectMapper {

    public static Project mapToProject(ProjectDto project) {

        Project projectDto = Project.builder()

                .projectID(project.getProjectID())
                .projectName(project.getProjectName())
                .projectDescription(project.getProjectDescription())
                .projectPhotoUrl(project.getProjectPhotoUrl())
                .projectStartDate(project.getProjectStartDate())
                .projectEndDate(project.getProjectEndDate())
                .projectCreatedDateTime(project.getProjectCreatedDateTime())
                .projectUpdatedDateTime(project.getProjectUpdatedDateTime())
                .projectTeamName(project.getProjectTeamName())
                .projectEstimatedHours(project.getProjectEstimatedHours())
                .projectStatus(project.getProjectStatus())
                .build();
        return projectDto;
    }


    public static ProjectDto mapToProjectDto(Project project) {

        ProjectDto projectDto = ProjectDto.builder()

                .projectID(project.getProjectID())
                .projectName(project.getProjectName())
                .projectDescription(project.getProjectDescription())
                .projectPhotoUrl(project.getProjectPhotoUrl())
                .projectStartDate(project.getProjectStartDate())
                .projectEndDate(project.getProjectEndDate())
                .projectCreatedDateTime(project.getProjectCreatedDateTime())
                .projectUpdatedDateTime(project.getProjectUpdatedDateTime())
                .projectTeamName(project.getProjectTeamName())
                .projectEstimatedHours(project.getProjectEstimatedHours())
                .projectStatus(project.getProjectStatus())
                .tasks(project.getTasks().stream().map((task) -> mapToTaskDto(task)).collect(Collectors.toList()))
                .build();
        return projectDto;
    }

}
