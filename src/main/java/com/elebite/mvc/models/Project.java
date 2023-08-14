package com.elebite.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
@Data: Dette er en annotation fra biblioteket Lombok, der genererer standardmetoder som toString, equals, hashCode og
getters/setters for alle felterne i klassen. Det hjælper med at reducere mængden af boilerplate-kode, der skal skrives.

@NoArgsConstructor: Dette er også en annotation fra Lombok, der genererer en standardkonstruktør uden argumenter.
Det gør det nemt at oprette objekter af klassen uden at skulle angive nogen værdier.

@AllArgsConstructor: Dette er en anden Lombok-annotation, der genererer en konstruktør, der tager imod argumenter for
alle felterne i klassen. Denne konstruktør gør det nemt at initialisere alle felterne på én gang.

@Builder: Dette er endnu en annotation fra Lombok, der genererer en builder-klasse til den pågældende klasse.
Builder-mønstret gør det nemmere at oprette komplekse objekter ved at kæde metodekald sammen.

@Entity: Dette er en annotation fra Java Persistence API (JPA), der markerer klassen som en JPA-entity.
En entity er en klasse, der er mappet til en database tabel.
I dette tilfælde vil klassen blive behandlet som en entitet og kunne gemmes i og hentes fra en database.

@Table(name = "projects"): Dette er en yderligere annotation fra JPA, der angiver navnet på den database tabel, som
entiteten skal gemmes i. I dette tilfælde vil entiteten blive gemt i en tabel med navnet "projects".

Samlet set betyder ovenstående kode, at den pågældende Java-klasse bliver behandlet som en JPA-entity, der er mappet
til en database tabel ved navn "projects".
Klassen genererer også metoder og konstruktører ved hjælp af Lombok-annotationerne, hvilket gør det nemmere at arbejde
med objekter af denne klasse.
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectID;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_description", columnDefinition="MEDIUMTEXT")
    private String projectDescription;

    @Column (name = "project_photo_url")
    private String projectPhotoUrl;

    @Column (name = "project_start_date")
    private LocalDate projectStartDate;

    @Column (name = "project_end_date")
    private LocalDate projectEndDate;

    @CreationTimestamp
    @Column (name = "project_created_date_time", updatable = false)
    private LocalDateTime projectCreatedDateTime;

    @UpdateTimestamp
    @Column (name = "project_updated_date_time")
    private LocalDateTime projectUpdatedDateTime;

    @Column(name = "project_team_name", length = 100)
    private String projectTeamName;

    @Column (name = "project_estimated_hours")
    private Double projectEstimatedHours;

    @Column (name = "project_status")
    private String projectStatus;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE)
    private List<Task> tasks = new ArrayList<>();

/*
Denne klasse er en JPA-entity, der repræsenterer et projekt i en applikation.
Project.java-klassen benyttes til at repræsentere og persistere projekter i
en database ved hjælp af JPA og Hibernate.
Persistere: "gemme eller opretholde data i en varig tilstand"
*/

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate() {

        if (this.projectStatus != null && this.projectStatus.isEmpty()) {
            this.projectStatus = null;
        }

        if (this.projectDescription != null && this.projectDescription.isEmpty()) {
            this.projectDescription = null;
        }
    }


    // Metode anvendt til testListAll()

    @Override
    public String toString() {
        return "Project{" +
                "projectID=" + projectID +
                ", projectName='" + projectName + '\'' +
               // ", projectDescription='" + projectDescription + '\'' +
                '}';
    }

}