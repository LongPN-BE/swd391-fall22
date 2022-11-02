package com.groupswd391.fall22.ProjectItem;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public interface ProjectItemService {
    List<ProjectItem> getProjectItems(int projectID, Pageable pageable);

    Optional<ProjectItem> getProjectItemById(int id);

    ResponseEntity<Map<String, Object>> getProjectItems(int page, int size);

    ProjectItem addProjectItem(ProjectItem projectItem);

    void deleteProjectItem(ProjectItem projectItem);

    ProjectItem updateProjectItem(ProjectItem projectItem);
}
