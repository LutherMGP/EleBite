package com.elebite.mvc.controllers;

import com.elebite.mvc.dto.ProjectDto;
import com.elebite.mvc.dto.TaskDto;
import com.elebite.mvc.models.Task;
import com.elebite.mvc.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /* ---------------------List alle Opgaver--------------------- */
    /* ----------------------tasks_list.html---------------------- */



    /* ------------------List alle Projekt Opgaver----------------
       -------------------project_tasks_list.html----------------- */

    @GetMapping("/projects/{projectId}/tasks")
    public String projectTasksList(@PathVariable("projectId") Long projectId, Model model) {
        List<TaskDto> tasks = taskService.findAllProjectTasks(projectId);
        model.addAttribute("tasks", tasks);
        return "project_tasks_list";
    }


    /* ----------------------Ny Projekt Opgave--------------------
       --------------------task_project_new.html------------------ */


    @GetMapping("/tasks/{projectId}/new")
    public String createTaskForm(@PathVariable("projectId") Long projectId, Model model) {
        Task task = new Task();
        model.addAttribute("projectId", projectId);
        model.addAttribute("task", task);
        return "tasks_new";
    }

    @PostMapping("/tasks/{projectId}")
    public String createTask(@PathVariable("projectId") Long projectId, @ModelAttribute("task") TaskDto taskDto,
                             BindingResult result,
                             Model model) {
        if(result.hasErrors()) {
            model.addAttribute("task", taskDto);
            return "projects_new";
        }
        taskService.createTask(projectId, taskDto);
        return "redirect:/projects/{projectId}/tasks"; // return "redirect:/projects/" + projectId;
    }


    /* ---------------------Editer Projekt Opgave----------------- */
    /* ---------------------task_project_edit.html---------------- */

    @GetMapping("/tasks/{taskId}/edit")
    public String editTaskForm(@PathVariable("taskId") long taskId, Model model) {
        TaskDto task = taskService.findByTaskId(taskId);
        model.addAttribute("task", task);
        return "tasks_edit";
    }

    @PostMapping("/tasks/{taskId}/edit")
    public String updateTask(@PathVariable("taskId") Long taskId,
                             @Valid @ModelAttribute("task") TaskDto task,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("task", task);
            return "tasks_edit";
        }
        TaskDto taskDto = taskService.findByTaskId(taskId);
        task.setTaskID(taskId);
        task.setProject(taskDto.getProject());
        taskService.updateTask(task);
        model.addAttribute("task", task);
        return "tasks_edit";
    }


    /* --------------------Projekt Opgave Detaljer---------------- */
    /* -------------------task_project_detail.html---------------- */

    @GetMapping("tasks/{taskId}")
    public String taskDetail(@PathVariable("taskId") Long taskId, Model model) {
        TaskDto taskDto = taskService.findByTaskId(taskId);
        model.addAttribute("task", taskDto);
        return "tasks_detail";
    }


    /* ----------------------Projekt Opgave Slet------------------ */
    /* --------------------task_project_delete.html--------------- */

    @GetMapping("/tasks/{taskId}/delete")
    public String deleteTask(@PathVariable("taskId") long taskId, @RequestParam("projectId") long projectId) {
        taskService.deleteTask(taskId);
        return "redirect:/projects/" + projectId + "/tasks";
    }


    /* -----------------------Projekt Opgave Søg------------------ */
    /* --------------------task_project_delete.html--------------- */

}