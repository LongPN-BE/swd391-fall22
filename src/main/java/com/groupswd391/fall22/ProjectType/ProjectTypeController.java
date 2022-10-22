package com.groupswd391.fall22.ProjectType;

import com.groupswd391.fall22.Major.Major;
import com.groupswd391.fall22.Major.MajorService;
import com.groupswd391.fall22.Project.Project;
import com.groupswd391.fall22.Project.dto.ProjectDTO;
import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.ProjectItem.dto.ProjectItemDTO;
import com.groupswd391.fall22.ProjectType.dto.ProjectTypeDTO;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProjectTypeController {
    private final String messageProjectTypeNotExist = "There is no project type exist with this id: ";
    private final String messageMajorNotExist = "There is no major exist with this id: ";

    @Autowired
    private ProjectTypeService projectTypeService;
    @Autowired
    private MajorService majorService;

//    private ProjectTypeRepository projectTypeRepository;
//
//    @GetMapping("/project-types")
//    public ResponseEntity<List<ProjectType>> listAllProjectTypes(){
//        List<ProjectType> listProjectTypes = projectTypeRepository.findAll();
//        if(listProjectTypes.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<ProjectType>>(listProjectTypes, HttpStatus.OK);
//    }

    //Get Project Types All List rest api
    @GetMapping("/project-types")
    public List<ProjectTypeDTO> getProjectTypesList(
            @RequestBody int majorID,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);

        List<ProjectTypeDTO> listReturn = new ArrayList<>();
        List<ProjectType> projectTypeList = projectTypeService.getProjectTypes(majorID, pageable);
        for (ProjectType projectType : projectTypeList) {
            String name = projectType.getName();
            String description = projectType.getDescription();

            listReturn.add(new ProjectTypeDTO(majorID, name, description));
        }
        return listReturn;
    }

    //Get Project Type By ID rest api
    @GetMapping("/project-type/{id}")
    public ResponseEntity<ProjectTypeDTO> getProjectTypeById(@PathVariable int id){
        ProjectType projectType = projectTypeService.getProjectTypeByID(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectTypeNotExist + id));

        ProjectTypeDTO projectTypeDTO = new ProjectTypeDTO();
        BeanUtils.copyProperties(projectType, projectTypeDTO);

        int majorID = projectType.getMajor().getId();
        projectTypeDTO.setMajorID(majorID);

        return ResponseEntity.ok(projectTypeDTO);
    }

    //Add Project Type rest api
    @PostMapping("/project-type")
    public ProjectType addProjectTypeItem(@RequestBody ProjectTypeDTO projectTypeDTO) {
        ProjectType projectType = new ProjectType();
        BeanUtils.copyProperties(projectTypeDTO, projectType);

        Major major = majorService.getMajorByID(projectTypeDTO.getMajorID())
                .orElseThrow(() -> new ResourceNotFoundException(messageMajorNotExist + projectTypeDTO.getMajorID()));
        projectType.setMajor(major);
        return projectTypeService.addProjectType(projectType);
    }

    //Update Project Type rest api
    @PutMapping("/project-type/{id}")
    public ResponseEntity<ProjectType> updateProjectTypeItem(@PathVariable("id") int id, @RequestBody ProjectTypeDTO projectTypeDetails) {
        ProjectType projectType = projectTypeService.getProjectTypeByID(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectTypeNotExist + id));

        BeanUtils.copyProperties(projectTypeDetails, projectType);

        Major major = majorService.getMajorByID(projectTypeDetails.getMajorID())
                .orElseThrow(() -> new ResourceNotFoundException(messageMajorNotExist + projectTypeDetails.getMajorID()));
        projectType.setMajor(major);

        ProjectType updatedProject = projectTypeService.updateProjectType(projectType);
        return ResponseEntity.ok(updatedProject);
    }

    //Delete Project Type rest api
    @DeleteMapping("/project-type/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProjectType(@PathVariable("id") int id){
        ProjectType projectType = projectTypeService.getProjectTypeByID(id)
                .orElseThrow(() -> new ResourceNotFoundException(messageProjectTypeNotExist + id));

        projectTypeService.deleteProjectType(projectType);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
