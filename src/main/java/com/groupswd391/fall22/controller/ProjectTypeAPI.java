package com.groupswd391.fall22.controller;



import com.groupswd391.fall22.entity.ProjectType;
import com.groupswd391.fall22.repository.ProjectTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectTypeAPI {

    @Autowired
    private ProjectTypeRepository projectTypeRepository;

    @RequestMapping(value = "/projectType/", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectType>> listAllMajor(){
        List<ProjectType> listProjectTypes = projectTypeRepository.findAll();
        if(listProjectTypes.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProjectType>>(listProjectTypes, HttpStatus.OK);
    }
}
