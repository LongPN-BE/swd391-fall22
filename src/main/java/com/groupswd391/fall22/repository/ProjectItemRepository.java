package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.ProjectItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectItemRepository extends JpaRepository<ProjectItem, String> {
}