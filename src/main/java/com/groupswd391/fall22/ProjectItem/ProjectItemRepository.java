package com.groupswd391.fall22.ProjectItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ProjectItemRepository extends JpaRepository<ProjectItem, Integer> {
    @Query(value = "SELECT * FROM project_item pi WHERE NOT pi.status = 3 AND pi.project_id = :projectID", nativeQuery = true)
    List<ProjectItem> getProjectItemsList(@Param("projectID") int projectID);

    @Query(value = "SELECT * FROM project_item pi WHERE NOT pi.status = 3 AND pi.id = :id", nativeQuery = true)
    ProjectItem getItem(@Param("id") int id);
}