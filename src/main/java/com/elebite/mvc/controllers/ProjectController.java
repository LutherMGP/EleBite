package com.elebite.mvc.controllers;

import com.elebite.mvc.dto.ProjectDto;
import com.elebite.mvc.models.Project;
import com.elebite.mvc.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/* Klassen ProjectController er en controller i denne Spring MVC (Model-View-Controller) applikation.
Dens formål er at håndtere indgående HTTP-anmodninger, kalde passende metoder i serviceklasser (som ProjectService)
baseret på disse anmodninger, og returnere passende HTTP-respons. */
@Controller
public class ProjectController {

    /*
    private ProjectService projectService;:
    Dette er en deklaration af en instansvariabel af typen ProjectService.
    Denne klasse en service, der håndterer forretningslogik relateret til projekter.

    @Autowired:
    Dette er en Spring-annotation, der anvendes til automatisk at injicere afhængigheder i Spring-styrede objekter.
    Denne annotation fortæller Spring, at den skal finde en instans af klassen ProjectService (eller en underklasse af
    den) i applikationens kontekst og bruge denne instans til at initialisere projectService-variablen.

    public ProjectController(ProjectService projectService) { ... }:
    Dette er konstruktøren for klassen ProjectController. Den tager en instans af ProjectService som parameter.
    Ved at bruge @Autowired på denne konstruktør fortæller Spring, at den skal levere en passende instans af
    ProjectService til denne konstruktør, når den opretter en instans af ProjectController.

    this.projectService = projectService;:
    Dette er en initialisering af instansvariablen projectService med den instans, der er leveret af Spring. */
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /* ----------------------List alle Projekter---------------------- */
    /* -----------------------projects_list.html---------------------- */
    /* Denne metode er ansvarlig for at hente en liste af projekter og sende dem til en visning for præsentation.

    @GetMapping("/projects"):
    Dette er en Spring MVC-annotation, der angiver, at denne metode skal kaldes, når serveren modtager en
    GET-anmodning til "/projects" stien.

    public String listProjects(Model model):
    Dette er en metode, der tager et Model objekt som input.
    Model er en del af Spring MVC og bruges til at videregive data til visningen.

    List<ProjectDto> projects = projectService.findAllProjects();:
    Dette er et kald til findAllProjects metoden i projectService, som returnerer en liste af alle ProjectDto objekter.
    ProjectDto er en Data Transfer Object, der repræsenterer et projekt.

    model.addAttribute("projects", projects);:
    Dette er et kald til addAttribute metoden på model objektet.
    Det tilføjer listen over ProjectDto objekter til modellen under nøgleordet "projects".
    Nøgleordet "projects" kan derefter bruges i visningen til at få adgang til dataene.

    return "projects_list";:
    Denne metode returnerer en streng, der repræsenterer navnet på visningen, der skal bruges til at præsentere dataene.
    I dette tilfælde er navnet på visningen "projects_list" (Spring fylder selv .html på filnavnet).
    Spring MVC vil bruge denne streng til at finde den rigtige visning (typisk en HTML-skabelon), der skal bruges til at
    sende dataene tilbage til klienten.*/

    @GetMapping("/projects")
    public String listProjects(Model model) {
        List<ProjectDto> projects = projectService.findAllProjects();
        model.addAttribute("projects", projects);
        return "projects_list";
    }

    /* ---------------------------Nyt Projekt------------------------- */
    /* -Dette er 2 metoder der håndterer oprettelsen af et nyt projekt-*/
    /* -------------------------projects_new.html----------------------*/

    /* Den første metode createProjectForm håndterer GET-anmodninger til
    "/projects/new" og returnerer en tom form til oprettelse af et nyt projekt.
    1) Den opretter en ny instans af Project-klassen.
    2) Den tilføjer denne nye Project-instans til modellen under nøgleordet "project".
    3) Den returnerer navnet på visningen der skal bruges til at vise formen.
    I dette tilfælde er det "projects_new".*/

    @GetMapping("/projects/new")
    public String createProjectForm(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects_new"; /* Bliver på projects_new.html siden */
    }
    /*-----------1) Formen præsenteres via "project_new"-------------*/
    /* 2) "project" attributterne indtastes og registeres via Thymeleaf */
    /*-----3) Den nye opdaterede "project" postes til databasen-------------*/

    /* Den anden metode håndterer POST-anmodninger til "/projects/new" */
    /* Dette vil blive udløst, når brugeren udfylder formen og klikker på en "Save Project".
    1) Den tager et Project-objekt som parameter. Spring vil automatisk binde dataene fra anmodningens krop til dette
    objekt ved hjælp af @ModelAttribute-annotationen. Dette betyder, at det vil se på hver parameter i anmodningens
    krop og forsøge at matche dem med felterne i Project-objektet.
    2) Den kalder saveProject-metoden i projectService, som gemmer det nye Project-objekt i databasen.
    3) Den returnerer en "redirect" streng, der fortæller Spring, at det skal sende en HTTP-omdirigering til klienten.
    I dette tilfælde vil klienten blive omdirigeret til "/projects" stien.
*/
    @PostMapping("/projects/new")
    public String saveProject(@Valid @ModelAttribute("project") ProjectDto projectDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("project", projectDto);
            return "projects_new";
        }
        projectService.saveProject(projectDto);
        return "redirect:/projects"; /* Dirigeres til projects_list.html */
    }

    /* -----------------------Edit Projekt------------------------- */
    /* Dette er 2 metoder der håndterer HTTP GET og POST anmodninger for at redigere et eksisterende projekt */

    /* Den første:
    1) @GetMapping("/projects/{projectId}/edit"):
    Denne annotation angiver, at editProjectForm metoden skal kaldes, når serveren modtager en GET anmodning til
    "/projects/{projectId}/edit" stien, hvor {projectId} er en pladsholder for det faktiske projekt-ID.

    2) public String editProjectForm(@PathVariable("projectId") long projectId, Model model):
    Dette er metoden, der håndterer GET anmodningen. Den tager projektets ID fra URL'en (specificeret ved
    @PathVariable("projectId") long projectId) og et Model objekt som parametre.

    3) ProjectDto project = projectService.findProjectById(projectId);:
    Dette er et kald til findProjectById metoden i projectService, som returnerer et ProjectDto objekt, der
    repræsenterer projektet med det givne ID.

    4) model.addAttribute("project", project);:
    Dette er et kald til addAttribute metoden på model objektet. Det tilføjer ProjectDto objektet til modellen under
    nøgleordet "project". Nøgleordet "project" kan derefter bruges i visningen til at få adgang til dataene.

    5) return "projects_edit";:
    Denne metode returnerer en streng, der repræsenterer navnet på visningen, der skal bruges til at præsentere dataene.
    I dette tilfælde er navnet på visningen sandsynligvis "projects_edit". Spring MVC vil bruge denne streng til at
    finde den rigtige visning (typisk en HTML-skabelon), der skal bruges til at sende dataene tilbage til klienten. */

    @GetMapping("/projects/{projectId}/edit")
    public String editProjectForm(@PathVariable("projectId") long projectId, Model model) {
        ProjectDto project = projectService.findProjectById(projectId);
        model.addAttribute("project", project);
        return "projects_edit";
    }

    /* Den anden:
    1) @PostMapping("/projects/{projectId}/edit"):
    Denne annotation angiver, at updateProject metoden skal kaldes, når serveren modtager en POST anmodning til
    "/projects/{projectId}/edit" stien.

    2) public String updateProject(@PathVariable("projectId") Long projectId, @ModelAttribute("project") ProjectDto pr.:
    Dette er metoden, der håndterer POST anmodningen. Den tager projektets ID fra URL'en og et ProjectDto objekt (som er
    blevet fyldt med data fra formen i visningen) som parametre.

    4) projectService.updateProject(project);:
    Dette er et kald til updateProject metoden i projectService, som sandsynligvis opdaterer projektet med de nye data.

    5) return "redirect:/projects";:
    Efter opdateringen af projektet, returnerer metoden en streng, der angiver, at brugeren skal omdirigeres til
    "/projects" stien. Dette er sandsynligvis stien, der viser en liste over alle projekter.*/

    @PostMapping("/projects/{projectId}/edit")
    public String updateProject(@PathVariable("projectId") Long projectId,
                                @Valid @ModelAttribute("project") ProjectDto project,
                                BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("project", project);
            return "projects_edit";
        }
        project.setProjectID(projectId);
        projectService.updateProject(project);
        return "projects_edit"; // return "redirect:/projects";
    }

    /* -----------------------Projekt Detaljer------------------------- */

    /* Projekt detaljer for et specifikt projekt }*/
    @GetMapping("projects/{projectId}")
    public String projectDetail(@PathVariable("projectId") long projectId, Model model) {
        ProjectDto projectDto = projectService.findProjectById(projectId);
        model.addAttribute("project", projectDto);
        return "projects_detail";
    }


    /* -----------------------Delete Projekt------------------------- */

    @GetMapping("/projects/{projectId}/delete")
    public String deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.delete(projectId);
        return "redirect:/projects";
    }

    /* -----------------------SEARCH Projekt------------------------- */

    @GetMapping("/projects/search")
    public String searchProject(@RequestParam(value = "query") String query, Model model) {
        List<ProjectDto> projects = projectService.searchProjects(query);
        model.addAttribute("projects", projects);
        return "projects_list";
    }

}

