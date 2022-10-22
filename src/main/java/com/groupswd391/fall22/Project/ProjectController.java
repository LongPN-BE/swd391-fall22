package com.groupswd391.fall22.Project;

import com.groupswd391.fall22.Project.dto.ProjectDTO;
import com.groupswd391.fall22.ProjectType.ProjectType;
import com.groupswd391.fall22.ProjectType.ProjectTypeService;
import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.User.UserService;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ProjectController {
//    @Autowired
//    ProjectService projectService;
//
//    //Select list of projects
//    @GetMapping("/projects")
//    public ResponseEntity<Map<String, Object>> getProjects(
//        @RequestParam(defaultValue = "0") int page,
//        @RequestParam(defaultValue = "7") int size) {
//        return projectService.getProjects(page, size);
//    }
//
//    //Insert 1 project
//    @PostMapping("/project")
//    public Project addProject(@RequestBody Project project){
//        return projectService.addProject(project);
//    }
//
//    //Remove 1 project
//    @DeleteMapping ("/project")
//    public Project deleteProject(@RequestBody Project project){
//        return projectService.deleteProject(project);
//    }
//
//    //Modify 1 project
//    @PutMapping ("/project")
//    public Project updateProject(@RequestBody Project project){
//        return projectService.updateProject(project);
//    }

    private final String messageProjectNotExist = "There is no project exist with this id: ";
    private final String messageProjectTypeNotExist = "There is no project type exist with this id: ";
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectTypeService projectTypeService;
    @Autowired
    private UserService userService;

    //Get Projects All List rest api
    @GetMapping("/projects")
    public List<ProjectDTO> getProjectsList(
            @RequestBody String dataSearch,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);

        List<ProjectDTO> listReturn = new ArrayList<>();
        List<Project> projectList = projectService.getProjects(dataSearch, pageable);
        for (Project project : projectList) {
            int userID = project.getUser().getId();
            int projectTypeID = project.getProjectType().getId();
            String name = project.getName();
            String description = project.getDescription();
            int status = project.getStatus();

            listReturn.add(new ProjectDTO(userID, projectTypeID, name, description, status));
        }
        return listReturn;
    }

    //Get Project By ID rest api
    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable int id){
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectNotExist + id));

        ProjectDTO projectDTO = new ProjectDTO();
        BeanUtils.copyProperties(project, projectDTO);

        int userID = project.getUser().getId();
        int projectTypeID = project.getProjectType().getId();
        projectDTO.setUserID(userID);
        projectDTO.setProjectTypeID(projectTypeID);

        return ResponseEntity.ok(projectDTO);
    }

    //Add Project rest api
    @PostMapping("/project")
    public Project addProject(@RequestBody ProjectDTO projectDTO) {
        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);

        ProjectType projectType = projectTypeService.getProjectTypeByID(projectDTO.getProjectTypeID())
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectTypeNotExist + projectDTO.getProjectTypeID()));
        project.setProjectType(projectType);

        User user = userService.getUsersByID(projectDTO.getUserID());
        project.setUser(user);
        return projectService.saveProject(project);
    }

    //Update Project rest api
    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project projectDetails) {
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectNotExist + id));

        project.setProjectType(projectDetails.getProjectType());
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setStatus(projectDetails.getStatus());

        Project updatedProject = projectService.saveProject(project);
        return ResponseEntity.ok(updatedProject);
    }

    //Active Project By Update Status rest api
    @PutMapping("/project/active/{id}")
    public ResponseEntity<Project> activeProject(@PathVariable("id") int id){
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectNotExist + id));

        //Change status of Project
        project.setStatus(1);
        Project hidedProject = projectService.saveProject(project);

        return ResponseEntity.ok(hidedProject);
    }

    //UnHide Project By Update Status rest api
    @PutMapping("/project/un-active/{id}")
    public ResponseEntity<Project> unActiveProject(@PathVariable("id") int id){
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectNotExist + id));

        //Change status of Project
        project.setStatus(0);
        Project unHidedProject = projectService.saveProject(project);

        return ResponseEntity.ok(unHidedProject);
    }

    //Delete Project rest api
    @DeleteMapping("/project/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProject(@PathVariable("id") int id){
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectNotExist + id));

        projectService.deleteProject(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
