package com.groupswd391.fall22.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public List<Project> projects(){
        return projectRepository.findAll();
    }
    public Project getProjectByID(int id){
        return projectRepository.findById(id).orElse(null);
    }

    public String deletetProject(int id){
        projectRepository.deleteById(id);
        return "Project removed " + id;
    }
    public Project updateProject(Project project){
        Project existingProject= projectRepository.findById(project.getId()).orElse(null);
        existingProject.setProjectType(project.getProjectType());
        existingProject.setName(project.getName());
        existingProject.setDescription(project.getDescription());
        return projectRepository.save(existingProject);
    }

}
