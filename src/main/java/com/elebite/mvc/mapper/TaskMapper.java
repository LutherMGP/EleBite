package com.elebite.mvc.mapper;

import com.elebite.mvc.dto.TaskDto;
import com.elebite.mvc.models.Task;

public class TaskMapper {

    public static Task mapToTask(TaskDto taskDto) {

        return Task.builder()
                .taskID(taskDto.getTaskID())
                .taskName(taskDto.getTaskName())
                .taskDescription(taskDto.getTaskDescription())
                .taskStartDate(taskDto.getTaskStartDate())
                .taskEndDate(taskDto.getTaskEndDate())
                .taskCreator(taskDto.getTaskCreator())
                .taskCreatedDateTime(taskDto.getTaskCreatedDateTime())
                .taskUpdatedDateTime(taskDto.getTaskUpdatedDateTime())
                .taskUpdatedCreator(taskDto.getTaskUpdatedCreator())
                .taskTeamID(taskDto.getTaskTeamID())
                .taskEstimatedHours(taskDto.getTaskEstimatedHours())
                .taskStatus(taskDto.getTaskStatus())
                .project(taskDto.getProject())
                .build();
    }

    public static TaskDto mapToTaskDto(Task task) {

        return TaskDto.builder()
                .taskID(task.getTaskID())
                .taskName(task.getTaskName())
                .taskDescription(task.getTaskDescription())
                .taskStartDate(task.getTaskStartDate())
                .taskEndDate(task.getTaskEndDate())
                .taskCreator(task.getTaskCreator())
                .taskCreatedDateTime(task.getTaskCreatedDateTime())
                .taskUpdatedDateTime(task.getTaskUpdatedDateTime())
                .taskUpdatedCreator(task.getTaskUpdatedCreator())
                .taskTeamID(task.getTaskTeamID())
                .taskEstimatedHours(task.getTaskEstimatedHours())
                .taskStatus(task.getTaskStatus())
                .project(task.getProject())
                .build();
    }
}
