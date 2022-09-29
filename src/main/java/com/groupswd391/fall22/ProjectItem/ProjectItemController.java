package com.groupswd391.fall22.ProjectItem;

import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.ProjectItem.ProjectItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectItemController {
    @Autowired
    ProjectItemRepository projectItemRepository;

    @RequestMapping(value = "/project-items/", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectItem>> listAllProjectItems(){
        List<ProjectItem> listProjectItems = projectItemRepository.findAll();
        if(listProjectItems.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProjectItem>>(listProjectItems, HttpStatus.OK);
    }
}
