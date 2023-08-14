package com.elebite.mvc;

import com.elebite.mvc.models.Project;
import com.elebite.mvc.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class ProjectRepositoryTests {
    @Autowired private ProjectRepository projectRepository;

    // Create (C_rud)
    @Test
    @Commit
    public void testAddNew() {
        // Arrange
        Project project = new Project();
        project.setProjectName("Martin Test5");
        project.setProjectDescription("Dette er en JUnit test5");
        project.setProjectStatus("Testing");

        // Act
        Project savedProject = projectRepository.save(project);

        // Assert
        Assertions.assertThat(savedProject).isNotNull();
        Assertions.assertThat(savedProject.getProjectID()).isGreaterThan(0);
    }

    // Read (c_R_ud)
    @Test
    public void testListAll() {
        // Arrange: Intet særligt arrangement er nødvendigt her

        // Act
        Iterable<Project> projects = projectRepository.findAll();

        // Assert
        Assertions.assertThat(projects).hasSizeGreaterThan(0);

        for (Project project : projects) {
            System.out.println(project);
        }
    }

    // Update (cr_U_d)
    @Test
    @Commit
    public void testUpdate() {
        // Arrange
        long projectID = 3;
        Optional<Project> optionalProject = projectRepository.findById(projectID);
        Project project = optionalProject.get();
        project.setProjectName("Nyt navn opdateret med JUnit: testUpdate");

        // Act
        projectRepository.save(project);

        // Assert
        Project updatedProject = projectRepository.findById(projectID).get();
        Assertions.assertThat(updatedProject.getProjectName()).isEqualTo("Nyt navn opdateret med JUnit: testUpdate");

    }

    // Read (c_R_ud) der identificerer et 'Project' via projectID inden delete testning ;-)

    @Test
    public void testGet() {
        // Arrange
        long projectID = 14;

        // Act
        Optional<Project> optionalProject = projectRepository.findById(projectID);

        // Assert
        Assertions.assertThat(optionalProject).isPresent();
        System.out.println(optionalProject.get());
    }

    // Delete (cru_D)

    @Test
    @Commit
    public void testDelete() {
        // Arrange
        long projectID = 14;

        // Act
        projectRepository.deleteById(projectID);

        // Assert
        Optional<Project> optionalProject = projectRepository.findById(projectID);
        Assertions.assertThat(optionalProject).isNotPresent();
    }

}
