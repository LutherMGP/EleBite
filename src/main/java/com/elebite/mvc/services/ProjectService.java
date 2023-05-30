package com.elebite.mvc.services;

import com.elebite.mvc.dto.ProjectDto;
import com.elebite.mvc.models.Project;

import java.util.List;

public interface ProjectService {

    /* ---------List alle Projekter---------- */
    List<ProjectDto> findAllProjects();


    /* -------------Nyt Projekt-------------- */
    Project saveProject(ProjectDto projectDto);


    /* -------------Edit Projekt------------- */
    ProjectDto findProjectById(long projectId);
    void updateProject(ProjectDto project);




    /* ------------Detail Projekt------------- */



    /* ------------Delete Projekt------------- */
    void delete(Long projectId);

    /* ---------------SEARCH---------------- */
    List<ProjectDto> searchProjects(String query);


}
