package com.elebite.mvc.services.impl;

import com.elebite.mvc.dto.ProjectDto;
import com.elebite.mvc.models.Project;
import com.elebite.mvc.repository.ProjectRepository;
import com.elebite.mvc.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.elebite.mvc.mapper.ProjectMapper.mapToProject;
import static com.elebite.mvc.mapper.ProjectMapper.mapToProjectDto;

@Service
public class ProjectServiceImpl implements ProjectService {

    /*---------------Forbindelse af ProjectServiceImpl-klassen med ProjectRepository----------------*/

    /* Samlet set sker først følgende:
    1) ProjectServiceImpl-klassen definerer en afhængighed af typen ProjectRepository */
    private ProjectRepository projectRepository;

    /* Derefter:
    2) Ved at bruge @Autowired i en konstruktør injiceres en implementering af denne afhængighed, når
    ProjectServiceImpl-objekter oprettes.
    Dette forbinder ProjectServiceImpl-klassen med ProjectRepository, så de kan samarbejde om at udføre
    databaseoperationer relateret til projekter. */
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    /*--------------------------------------List alle Projekter----------------------------------------*/
    /*-----------------------Anvendes i ProjectService.java som "findAllProjects()"--------------------*/


    /* @Override: er en annotation i Java, der bruges til at markere en metode i en underklasse, der overskriver en
    metode i dens superklasse. Den bruges til at sikre, at metodeoverskridelsen sker korrekt i overensstemmelse med
    Java's regler for nedarvning og polymorfi.
    Det er vigtigt at bemærke, at brugen af @Override er en god praksis, men ikke obligatorisk.
    Det er dog anbefalet at bruge det, da det hjælper med at sikre korrekt og forventet adfærd, når du arbejder med
    metodeoverskridelse i Java. */
    /* Dette er en metodeerklæring, der angiver, at denne metode returnerer en liste af ProjectDto-objekter.
    Metodenavnet er findAllProjects og metoden benyttes i ProjectService.java til at hente alle projekter. */
    @Override
    public List<ProjectDto> findAllProjects() {

    /* Her kaldes metoden findAll() på projectRepository-objektet, som er en instans af ProjectRepository.
    findAll()-metoden returnerer en liste (navngivet: projects) af Project-objekter, der repræsenterer
    alle projekterne i databasen eller datakilden. */
        List<Project> projects = projectRepository.findAll();

    /* Denne linje udfører en række operationer på listen af Project-objekter for at konvertere dem til en liste af
    ProjectDto-objekter og returnerer resultatet.

    1) projects.stream():
    Dette konverterer projects-listen til en strøm, hvilket muliggør sekventiel eller parallelt behandling af
    elementerne i listen.

    2) .map((project) -> mapToProjectDto(project)):
    Dette anvender en funktion mapToProjectDto() på hvert Project-objekt i strømmen for at konvertere dem til
    ProjectDto-objekter.

    3) .collect(Collectors.toList()):
    Dette samler de konverterede ProjectDto-objekter i en liste og returnerer den som resultat. */
        return projects.stream().map((project) -> mapToProjectDto(project)).collect(Collectors.toList());
    }

    /* Metoden mapToProjectDto tager en instans af klassen Project som parameter.
Koden konverterer et objekt af typen Project til et objekt af typen ProjectDto.
Dette mønster er almindeligt i applikationer, der anvender Data Transfer Objects (DTO), som er designet til at
transportere data mellem processer, typisk mellem lagene i en flerlags arkitektur.*/

    // mapToProjectDto er flyttet til ProjectMapper


    /*--------------------------------------------Nyt Projekt------------------------------------------------*/

    @Override
    public Project saveProject(ProjectDto projectDto) {
        Project project = mapToProject(projectDto);
        return projectRepository.save(project);
    }


    /*--------------------------------------------Edit Projekt------------------------------------------------*/

    @Override
    public ProjectDto findProjectById(long projectId) {
        Project project = projectRepository.findById(projectId).get();
        return mapToProjectDto(project);
    }

    @Override
    public void updateProject(ProjectDto projectDto) {
        Project project = mapToProject(projectDto);
        projectRepository.save(project);
    }



    /*------------------------------------------Detail Projekt ----------------------------------------------*/



    /*------------------------------------------Delete Projekt ----------------------------------------------*/

    @Override
    public void delete(Long projectId) {
        projectRepository.deleteById(projectId);
    }


    /*------------------------------------------SEARCH Project ----------------------------------------------*/

    @Override
    public List<ProjectDto> searchProjects(String query) {
        List<Project> projects = projectRepository.searchProjects(query);
        return projects.stream().map(project -> mapToProjectDto(project)).collect(Collectors.toList());
    }


}
