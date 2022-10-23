package com.groupswd391.fall22.Project;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query(value = "SELECT * " +
            "FROM project p " +
            "INNER JOIN project_type pt " +
            "ON p.project_type_ID = pt.id " +
            "WHERE p.status = 1 AND pt.status = 1 AND p.name LIKE %:dataSearch% ", nativeQuery = true)
    List<Project> findProjectList(@Param("dataSearch")String dataSearch);

    @Modifying
    @Query(value = "UPDATE project SET status = 3 WHERE id = :id", nativeQuery = true)
    void deleteRequestProject(@Param("id")int id);

    @Query(value = "SELECT * FROM project p WHERE NOTE p.status = 3 AND p.id = :id", nativeQuery = true)
    Project getProject(@Param("id") int id);
}