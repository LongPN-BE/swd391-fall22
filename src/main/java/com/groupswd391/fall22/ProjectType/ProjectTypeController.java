package com.groupswd391.fall22.ProjectType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectTypeController {

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @GetMapping("/project-types")
    public ResponseEntity<List<ProjectType>> listAllProjectTypes(){
        List<ProjectType> listProjectTypes = projectTypeRepository.findAll();
        if(listProjectTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProjectType>>(listProjectTypes, HttpStatus.OK);
    }
}
