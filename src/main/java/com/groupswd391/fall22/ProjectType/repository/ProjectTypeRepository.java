package com.groupswd391.fall22.projectType.repository;

import com.groupswd391.fall22.projectType.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Integer> {

    @Query(value = "SELECT * FROM project_type pt WHERE NOT pt.status = 3 AND pt.id = :id", nativeQuery = true)
    ProjectType getProjectTypeByID(@Param("id") int id);

    @Query(value = "SELECT * FROM project_type pt WHERE NOT pt.status = 3 AND pt.major_ID = :majorID", nativeQuery = true)
    List<ProjectType> findProjectTypeList(@Param("majorID")int majorID);
}