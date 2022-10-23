package com.groupswd391.fall22.Application;

import com.groupswd391.fall22.Application.DTO.ApplicationRequest;
import com.groupswd391.fall22.Application.DTO.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    final
    ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping
    public ResponseEntity<Map<String, Object>> getApplications(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = applicationService.getApplications( page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Lấy application theo user ID",
            description = "Truyền giá trị id user muốn tìm"
    )
    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String, Object>> getApplicationsByUserID(
            @PathVariable int userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = applicationService.getApplicationByUserID(userId, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Lấy application theo projectItem ID",
            description = "Truyền giá trị id projectItem muốn tìm"
    )
    @GetMapping("/projectitem/{projectitemid}")
    public ResponseEntity<Map<String, Object>> getApplicationsByProjectItemID(
            @PathVariable int projectitemid,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = applicationService.getApplicationByProjectItemID(projectitemid, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 Application mới ",
            description = "Tạo 1 Application mới "
    )
    @PostMapping()
    ApplicationResponse addProduct(@Valid @RequestBody ApplicationRequest applicationRequest) {
        return applicationService.createApplication(applicationRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteApplication(@PathVariable int id) {
        if (applicationService.deleteApplication(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin application ",
            description = "truyền id application muốn thay đổi"
    )
    @PutMapping("/{id}")
    ApplicationResponse updateApplication(@Valid @RequestBody ApplicationRequest applicationRequest, @PathVariable int id) {
        return applicationService.updateApplication(applicationRequest, id);
    }
}
