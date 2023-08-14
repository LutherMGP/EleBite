package com.elebite.mvc.repository;

import com.elebite.mvc.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProjectRepository extends JpaRepository<Project, Long> {

    /*---------------------- SEARCH ------------------------*/

    Optional<Project> findByProjectName(String url);
    @Query("SELECT c from Project c " +
            "WHERE c.projectName LIKE CONCAT('%', :query, '%')")
    List<Project> searchProjects(String query);
}

/*

SQL scriptet ville se således ud: SELECT * FROM Project WHERE projectName = 'aktuelle projectnavn';

------------

SELECT c from Project c
erklærer, at vi ønsker at hente instanser af Project (angivet her som c).

WHERE c.projectName LIKE CONCAT('%', :query, '%')
angiver et filter, der skal anvendes på de projekter, vi henter.
Dette filter fungerer ved at søge efter projekter, hvis projectName indeholder den streng, der er angivet ved :query.

CONCAT('%', :query, '%')
bruges til at skabe en streng, der starter og slutter med '%', med :query i midten.
I SQL bruges '%' til at angive en vilkårlig række tegn.
Så i dette tilfælde vil vi søge efter projekter, hvis navne indeholder den angivne streng som en understreng.

List<Project> searchProjects(String query);
Denne metode erklærer en operation, der henter en liste af Project-objekter, hvis navne matcher den givne søgestreng.

--------------

JDBC koden som den kunne se ud:

    public List<Project> searchProjects(String query) throws SQLException {
        String sql = "SELECT * FROM Project WHERE projectName LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + query + "%");
            try (ResultSet rs = ps.executeQuery()) {
                List<Project> projects = new ArrayList<>();
                while (rs.next()) {
                    Project project = new Project(rs.getLong("id"), rs.getString("projectName"));
                    // ... Håndtere andre feltudfyldninger...
                    projects.add(project);
                }
                return projects;
            }
        }
    }

 */
