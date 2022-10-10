package com.groupswd391.fall22.ProjectItem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectItemController {
    ProjectItemService projectItemService;

    @GetMapping("/project-items")
    public ResponseEntity<Map<String, Object>> getProjectItems(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "5") int size){
        return projectItemService.getProjectItems(page, size);
    }

    //Add 1 project item
    @PostMapping("/project-item")
    public ProjectItem addProjectItem(@RequestBody ProjectItem projectItem){
        return projectItemService.addProjectItem(projectItem);
    }

    //Remove 1 project item
    @DeleteMapping ("/project-item")
    public ProjectItem deleteProjectItem(@RequestBody ProjectItem projectItem){
        return projectItemService.deleteProjectItem(projectItem);
    }

    //Modify 1 project item
    @PutMapping ("/project-item")
    public ProjectItem updateProjectItem(@RequestBody ProjectItem projectItem){
        return projectItemService.updateProjectItem(projectItem);
    }
}
