package com.groupswd391.fall22.projectType.service.imp;

import com.groupswd391.fall22.projectType.entity.ProjectType;
import com.groupswd391.fall22.projectType.repository.ProjectTypeRepository;
import com.groupswd391.fall22.projectType.service.ProjectTypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {
    private final ProjectTypeRepository projectTypeRepository;

    public ProjectTypeServiceImpl(ProjectTypeRepository projectTypeRepository) {
        this.projectTypeRepository = projectTypeRepository;
    }

    @Override
    public Optional<ProjectType> getProjectTypeByID(int id) {
        return Optional.ofNullable(projectTypeRepository.getProjectTypeByID(id));
    }

    @Override
    public List<ProjectType> getProjectTypes(Pageable pageable) {
        return projectTypeRepository.findAll();
    }

    @Override
    public List<ProjectType> getProjectTypesByMajorID(int majorID, Pageable pageable) {
        return projectTypeRepository.findProjectTypeList(majorID);
    }

    @Override
    public ProjectType addProjectType(ProjectType projectType) {
        return projectTypeRepository.save(projectType);
    }

    @Override
    public ProjectType deleteProjectType(ProjectType projectType) {
        ProjectType existingProjectType = projectTypeRepository.findById(projectType.getId()).orElse(null);
        if (existingProjectType != null) {
            projectTypeRepository.delete(projectType);
            existingProjectType.setStatus(3);
            return projectTypeRepository.save(existingProjectType);
        }
        return null;
    }

    @Override
    public ProjectType updateProjectType(ProjectType projectType) {
        ProjectType existingProjectType = projectTypeRepository.findById(projectType.getId()).orElse(null);
        if (existingProjectType != null) {
            existingProjectType.setName(projectType.getName());
            existingProjectType.setDescription(projectType.getDescription());
            existingProjectType.setMajor(projectType.getMajor());
            return projectTypeRepository.save(existingProjectType);
        }
        return null;
    }
}
