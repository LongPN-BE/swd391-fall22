package com.groupswd391.fall22.ProjectType;

import com.groupswd391.fall22.ProjectType.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Integer> {

//    @Query("SELECT e FROM ProjectType e WHERE e.id = :id")
//    ProjectType findById(@Param("id") int id);
}