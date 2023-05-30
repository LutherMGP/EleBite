package com.elebite.mvc.services;

import com.elebite.mvc.dto.TaskDto;

import java.util.List;

public interface TaskService {


    /* ---------------------List alle Opgaver--------------------- */
    /* ----------------------tasks_list.html---------------------- */


    /* ------------------List alle Projekt Opgaver---------------- */
    /* -------------------project_tasks_list.html----------------- */
    List<TaskDto> findAllProjectTasks(Long projectId);


    /* ----------------------Ny Projekt Opgave-------------------- */
    /* --------------------task_project_new.html------------------ */
    void createTask(Long projectId, TaskDto taskDto);


    /* ---------------------Edit Projekt Opgave------------------- */
    void updateTask(TaskDto taskDto);

    /* -------------------------Detail Task----------------------- */
    TaskDto findByTaskId(Long taskId);

    /* ------------------------Delete Projekt--------------------- */
    void deleteTask(long taskId);





}
