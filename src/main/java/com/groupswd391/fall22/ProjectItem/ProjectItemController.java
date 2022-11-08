package com.groupswd391.fall22.ProjectItem;

import com.groupswd391.fall22.Project.Project;
import com.groupswd391.fall22.Project.ProjectService;
import com.groupswd391.fall22.ProjectItem.dto.ProjectItemDTO;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectItemController {
//    ProjectItemService projectItemService;
//
//    @GetMapping("/project-items")
//    public ResponseEntity<Map<String, Object>> getProjectItems(
//            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
//            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
//        return projectItemService.getProjectItems(page, size);
//    }
//
//    //Add 1 project item
//    @PostMapping("/project-item")
//    public ProjectItem addProjectItem(@RequestBody ProjectItem projectItem){
//        return projectItemService.addProjectItem(projectItem);
//    }
//
//    //Remove 1 project item
//    @DeleteMapping ("/project-item")
//    public ProjectItem deleteProjectItem(@RequestBody ProjectItem projectItem){
//        return projectItemService.deleteProjectItem(projectItem);
//    }
//
//    //Modify 1 project item
//    @PutMapping ("/project-item")
//    public ProjectItem updateProjectItem(@RequestBody ProjectItem projectItem){
//        return projectItemService.updateProjectItem(projectItem);
//    }

    private final String messageProjectItemNotExist = "There is no project item exist with this id: ";
    private final String messageProjectNotExist = "There is no project exist with this id: ";
    ProjectItemService projectItemService;
    @Autowired
    private ProjectService projectService;

    //Get Project Items All List rest api
    @GetMapping("/project-items")
    public List<ProjectItemDTO> getProjectItemsList(
            @RequestParam(name = "projectID") int projectID,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);

        List<ProjectItemDTO> listReturn = new ArrayList<>();
        List<ProjectItem> projectItemList = projectItemService.getProjectItems(projectID, pageable);
        for (ProjectItem projectItem : projectItemList) {
            Integer id = projectItem.getId();
            Integer neededNum = projectItem.getNeededNum();
            Integer soldNum = projectItem.getSoldNum();
            Integer appliedNum = projectItem.getAppliedNum();
            double minPrice = projectItem.getMinPrice();
            double maxPrice = projectItem.getMaxPrice();
            String requirement = projectItem.getRequirement();

            listReturn.add(new ProjectItemDTO(id,projectID, neededNum, soldNum, appliedNum, minPrice, maxPrice, requirement));
        }
        return listReturn;
    }

    //Get Project Item By ID rest api
    @GetMapping("/project-item/{id}")
    public ResponseEntity<ProjectItemDTO> getProjectItemById(@PathVariable int id){
        ProjectItem projectItem = projectItemService.getProjectItemById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectItemNotExist + id));

        ProjectItemDTO projectItemDTO = new ProjectItemDTO();
        BeanUtils.copyProperties(projectItem, projectItemDTO);

        int projectID = projectItem.getProject().getId();
        projectItemDTO.setProjectID(projectID);

        return ResponseEntity.ok(projectItemDTO);
    }

    //Add Project Item rest api
    @PostMapping("/project-item")
    public ProjectItem addProjectItem(@RequestBody ProjectItemDTO projectItemDTO) {
        ProjectItem projectItem = new ProjectItem();
        BeanUtils.copyProperties(projectItemDTO, projectItem);

        Project project = projectService.getProjectById(projectItemDTO.getProjectID())
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectNotExist + projectItemDTO.getProjectID()));
        projectItem.setProject(project);
        return projectItemService.addProjectItem(projectItem);
    }

    //Update Project Item rest api
    @PutMapping("/project-item/{id}")
    public ResponseEntity<ProjectItem> updateProjectItem(@PathVariable("id") int id, @RequestBody ProjectItem projectItemDetails) {
        ProjectItem projectItem = projectItemService.getProjectItemById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectItemNotExist + id));

        BeanUtils.copyProperties(projectItemDetails, projectItem);

        ProjectItem updatedProject = projectItemService.updateProjectItem(projectItem);
        return ResponseEntity.ok(updatedProject);
    }

    //Delete Project Item rest api
    @DeleteMapping("/project-item/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProject(@PathVariable("id") int id){
        ProjectItem projectItem = projectItemService.getProjectItemById(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectItemNotExist + id));

        projectItemService.deleteProjectItem(projectItem);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
