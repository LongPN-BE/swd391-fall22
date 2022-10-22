package com.groupswd391.fall22.ProjectItem;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProjectItemService {
    List<ProjectItem> getProjectItems(int projectID, Pageable pageable);

    Optional<ProjectItem> getProjectItemById(int id);

    ResponseEntity<Map<String, Object>> getProjectItems(int page, int size);

    ProjectItem addProjectItem(ProjectItem projectItem);

    ProjectItem deleteProjectItem(ProjectItem projectItem);

    ProjectItem updateProjectItem(ProjectItem projectItem);
}
