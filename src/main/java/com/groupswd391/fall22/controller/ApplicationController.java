package com.groupswd391.fall22.controller;

import com.groupswd391.fall22.entity.Application;
import com.groupswd391.fall22.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {
    @Autowired
    ApplicationRepository applicationRepository;

    @RequestMapping(value = "/applications/", method = RequestMethod.GET)
    public ResponseEntity<List<Application>> listAllApplications(){
        List<Application> listApplications = applicationRepository.findAll();
        if(listApplications.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Application>>(listApplications, HttpStatus.OK);
    }
}
