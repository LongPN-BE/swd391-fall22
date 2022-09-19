package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {
}