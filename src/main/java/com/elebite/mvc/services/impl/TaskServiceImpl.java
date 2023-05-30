package com.elebite.mvc.services.impl;

import com.elebite.mvc.dto.TaskDto;
import com.elebite.mvc.mapper.TaskMapper;
import com.elebite.mvc.models.Project;
import com.elebite.mvc.models.Task;
import com.elebite.mvc.repository.ProjectRepository;
import com.elebite.mvc.repository.TaskRepository;
import com.elebite.mvc.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.elebite.mvc.mapper.TaskMapper.mapToTask;
import static com.elebite.mvc.mapper.TaskMapper.mapToTaskDto;

@Service
public class TaskServiceImpl implements TaskService {

    /*---------------Forbindelse af TaskServiceImpl-klassen med TaskRepository----------------*/
    /*------------Forbindelse af ProjectServiceImpl-klassen med ProjectRepository-------------*/

    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    /*--------------------------------------List alle Opgaver----------------------------------------*/
    /* ----------------------tasks_list.html---------------------- */
    // @Override
    //public TaskDto findByTaskId(Long taskId) {
    //     Task task = taskRepository.findById(taskId).get();
    //     return mapToTaskDto(task);
    // }

    /* ---------------------------------List alle Projekt Opgaver----------------------------------- */
    /* -------------------project_tasks_list.html----------------- */

    @Override
    public List<TaskDto> findAllProjectTasks(Long projectId) {
        List<Task> tasks = taskRepository.findByProjectId(projectId);
        return tasks.stream()
                .map(TaskMapper::mapToTaskDto)
                .collect(Collectors.toList());
    }

    public TaskDto findByTaskId(Long taskId) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            return TaskMapper.mapToTaskDto(optionalTask.get());
        } else {
            throw new NoSuchElementException("No Task found with ID " + taskId);
        }
    }


    /*------------------------------------------Ny Opgave---------------------------------------------*/
    /* --------------------task_project_new.html------------------ */

    @Override
    public void createTask(Long projectId, TaskDto taskDto) {
        Project project = projectRepository.findById(projectId).get();
        Task task = mapToTask(taskDto);
        task.setProject(project);
        taskRepository.save(task);
    }

    /*------------------------------------------Edit Opgave-------------------------------------------*/

    @Override
    public void updateTask(TaskDto taskDto) {
        Task task = mapToTask(taskDto);
        taskRepository.save(task);
    }


    /*------------------------------------------Detail Opgave ----------------------------------------------*/

    /*------------------------------------------Delete Opgave ----------------------------------------------*/
    @Override
    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);
    }



}
