package com.groupswd391.fall22.ProjectItem;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProjectItemService {
    public ResponseEntity<Map<String, Object>> getProjectItems(int page, int size);

    public ProjectItem addProjectItem(ProjectItem projectItem);

    public ProjectItem deleteProjectItem(ProjectItem projectItem);

    public ProjectItem updateProjectItem(ProjectItem projectItem);
}
