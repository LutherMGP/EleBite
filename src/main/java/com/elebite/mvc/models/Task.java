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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description", columnDefinition="MEDIUMTEXT")
    private String taskDescription;

    @Column (name = "task_start_date")
    private LocalDate taskStartDate;

    @Column (name = "task_end_date")
    private LocalDate taskEndDate;

    @Column (name = "task_creator")
    private String taskCreator;

    @CreationTimestamp
    @Column (name = "task_created_date_time", updatable = false)
    private LocalDateTime taskCreatedDateTime;

    @UpdateTimestamp
    @Column (name = "task_updated_date_time")
    private LocalDateTime taskUpdatedDateTime;

    @Column (name = "task_updated_creator")
    private String taskUpdatedCreator;

    @Column (name = "task_team_id")
    private Long taskTeamID;

    @Column (name = "task_estimated_hours")
    private Double taskEstimatedHours;

    @Column (name = "task_status")
    private String taskStatus;

    @ManyToOne
    @JoinColumn(name="project_id", nullable = false)
    private Project project;
}
