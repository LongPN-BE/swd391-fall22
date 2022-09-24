package com.groupswd391.fall22.controller;

import com.groupswd391.fall22.entity.Project;
import com.groupswd391.fall22.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/projects/", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> listAllProjects(){
        List<Project> listProjects = projectRepository.findAll();
        if(listProjects.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Project>>(listProjects, HttpStatus.OK);
    }
}
