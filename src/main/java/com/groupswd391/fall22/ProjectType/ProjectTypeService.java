package com.groupswd391.fall22.ProjectType;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface ProjectTypeService {
    Optional<ProjectType> getProjectTypeByID(int id);

    List<ProjectType> getProjectTypes(int majorID, Pageable pageable);

    ProjectType addProjectType(ProjectType projectType);

    ProjectType deleteProjectType(ProjectType projectType);

    ProjectType updateProjectType(ProjectType projectType);
}
