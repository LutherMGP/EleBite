package com.elebite.mvc.repository;

import com.elebite.mvc.dto.TaskDto;
import com.elebite.mvc.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.project.projectID = :projectId")
    List<Task> findByProjectId(Long projectId);

    /*---------------------- SEARCH ------------------------*/




}
