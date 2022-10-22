package com.groupswd391.fall22.Project;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Override
//    public Project addProject(Project project){
//        return projectRepository.save(project);
//    }
//
////    public List<Project> getProjects(){ return projectRepository.findAll(); }
//
//    @Override
//    public ResponseEntity<Map<String, Object>> getProjects(int page, int size) {
//        try {
//            List<Project> projects;
//            Pageable paging = PageRequest.of(page, size);
//
//            Page<Project> pageTuts;
//            pageTuts = projectRepository.findAll(paging);
//
//            projects = pageTuts.getContent();
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("projects", projects);
//            response.put("currentPage", pageTuts.getNumber());
//            response.put("totalItems", pageTuts.getTotalElements());
//            response.put("totalPages", pageTuts.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Override
//    public Project deleteProject(Project project){
//        Project existingProject= projectRepository.getProjectTypeByID(project.getId()).orElse(null);
//        if (existingProject != null) {
//            existingProject.setStatus(false);
//            return projectRepository.save(existingProject);
//        }
//        return null;
//    }
//
//    @Override
//    public Project updateProject(Project project){
//        Project existingProject= projectRepository.getProjectTypeByID(project.getId()).orElse(null);
//        if (existingProject != null){
//            existingProject.setProjectType(project.getProjectType());
//            existingProject.setName(project.getName());
//            existingProject.setDescription(project.getDescription());
//            return projectRepository.save(existingProject);
//        }
//        return null;
//    }

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getProjects(String dataSearch, Pageable pageable) {
//        List<Project> resultList = projectRepository.findAll();
        return projectRepository.findProjectList(dataSearch, pageable);
    }

    @Override
    public <S extends Project> S saveProject(S project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> getProjectById(int id) {
        return Optional.ofNullable(projectRepository.getProject(id));
    }

    @Override
    public void deleteProject(Project entity) {
        projectRepository.deleteRequestProject(entity.getId());
    }
}
