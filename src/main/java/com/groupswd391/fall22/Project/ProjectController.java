//package com.groupswd391.fall22.Project;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//public class ProjectController {
//    @Autowired
//    ProjectService projectService;
//
//    @Autowired
//    ProjectRepository projectRepository;
//
//    @RequestMapping(value = "/project", method = RequestMethod.GET)
//    public Project findProjectByID(@PathVariable int id){
//        return projectService.getProjectByID(id);
//    }
//
//    @RequestMapping(value = "/projects", method = RequestMethod.GET)
//    public ResponseEntity<Map<String, Object>> projects(
////            Pageable pageable
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "7") int size) {
//
//        try {
//
//            List<Project> projects = new ArrayList<Project>();
//            Pageable paging = PageRequest.of(page, size);
//            Page<Project> pageTuts;
//
//            pageTuts = projectRepository.findAll(paging);
//
//            projects = pageTuts.getContent();
//            System.out.println(projects);
//
//
//            Map<String, Object> response = new HashMap<>();
//            response.put("projects", projects);
//            response.put("currentPage", pageTuts.getNumber());
//            response.put("totalItems", pageTuts.getTotalElements());
//            response.put("totalPages", pageTuts.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @RequestMapping(value = "/project", method = RequestMethod.PUT)
//    public Project project(@RequestBody Project project){
//        return projectService.save(project);
//    }
//
//    @RequestMapping(value = "/project", method = RequestMethod.DELETE)
//    public String deleteProject(@PathVariable int id){
//        return projectService.deletetProject(id);
//    }
//}
