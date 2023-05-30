package com.elebite.mvc.repository;

import com.elebite.mvc.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProjectRepository extends JpaRepository<Project, Long> {

    /*---------------------- SEARCH ------------------------*/

    Optional<Project> findByProjectName(String url);
    @Query("SELECT c from Project c WHERE c.projectName LIKE CONCAT('%', :query, '%')")
    List<Project> searchProjects(String query);
}
