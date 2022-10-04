package com.groupswd391.fall22.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project addProject(Project project){
        return projectRepository.save(project);
    }

//    public List<Project> getProjects(){ return projectRepository.findAll(); }

    @Override
    public ResponseEntity<Map<String, Object>> getProjects(int page, int size) {
        try {
            List<Project> projects;
            Pageable paging = PageRequest.of(page, size);

            Page<Project> pageTuts;
            pageTuts = projectRepository.findAll(paging);

            projects = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("projects", projects);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String deleteProject(int id){
        projectRepository.deleteById(id);
        return "Project removed is " + id;
    }

    @Override
    public Project updateProject(Project project){
        Project existingProject= projectRepository.findById(project.getId()).orElse(null);
        existingProject.setProjectType(project.getProjectType());
        existingProject.setName(project.getName());
        existingProject.setDescription(project.getDescription());
        return projectRepository.save(existingProject);
    }
}
