package com.groupswd391.fall22.Project;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface ProjectService {
//    Project addProject(Project project);
//
//    ResponseEntity<Map<String, Object>> getProjects(int page, int size);
//
//    Project deleteProject(Project project);
//
//    Project updateProject(Project project);

    List<Project> getProjects(String dataSearch, Pageable pageable);

    <S extends Project> S saveProject(S project);

    Optional<Project> getProjectById(int id);

    void deleteProject(Project project);

}
