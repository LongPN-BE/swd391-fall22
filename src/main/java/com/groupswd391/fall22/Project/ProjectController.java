package com.groupswd391.fall22.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    //Select list of projects
    @GetMapping("/projects")
    public ResponseEntity<Map<String, Object>> getProjects(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "7") int size) {
        return projectService.getProjects(page, size);
    }

    //Insert 1 project
    @PostMapping("/project")
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    //Remove 1 project
    @DeleteMapping ("/project")
    public String deleteProject(@PathVariable int id){
        return projectService.deleteProject(id);
    }

    //Modify 1 project
    @PutMapping ("/project")
    public Project updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }
}
