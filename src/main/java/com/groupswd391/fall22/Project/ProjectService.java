package com.groupswd391.fall22.Project;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ProjectService {
    Project addProject(Project project);

//    public List<Project> getProjects();

    ResponseEntity<Map<String, Object>> getProjects(int page, int size);

    String deleteProject(int id);

    Project updateProject(Project project);
}
