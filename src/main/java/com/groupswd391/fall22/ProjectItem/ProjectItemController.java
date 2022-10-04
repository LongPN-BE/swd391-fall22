package com.groupswd391.fall22.ProjectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectItemController {
    @Autowired
    ProjectItemRepository projectItemRepository;

    @GetMapping("/project-items")
    public ResponseEntity<List<ProjectItem>> listAllProjectItems(){
        List<ProjectItem> listProjectItems = projectItemRepository.findAll();
        if(listProjectItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProjectItem>>(listProjectItems, HttpStatus.OK);
    }
}
