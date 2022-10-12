package com.groupswd391.fall22.Application;

import com.groupswd391.fall22.Application.DTO.ApplicationRequest;
import com.groupswd391.fall22.Application.DTO.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    ApplicationService applicationService;


    @Operation(
            summary = "Lấy application theo user ID",
            description = "Truyền giá trị id user muốn tìm, bắt buộc"
    )
    @GetMapping("/{userID}")
    public ResponseEntity<Map<String, Object>> getApplicationsByUserID(
            @PathVariable(required = true) int userID,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = applicationService.getApplicationByUserID(userID, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 Application mới ",
            description = "Tạo 1 Application mới ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "500", description = "Lỗi Server"),
                    @ApiResponse(responseCode = "403", description = "Truyền sai dữ liệu"),
                    @ApiResponse(responseCode = "401", description = "Lỗi Phân quyền"),
                    @ApiResponse(responseCode = "400", description = "Truyền sai dữ liệu"),
            }
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
            description = "truyền id application muốn thay đổi",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "500", description = "Lỗi Server"),
                    @ApiResponse(responseCode = "403", description = "Truyền sai dữ liệu"),
                    @ApiResponse(responseCode = "401", description = "Lỗi Phân quyền"),
                    @ApiResponse(responseCode = "400", description = "Truyền sai dữ liệu"),
            }
    )
    @PutMapping("/{id}")
    ApplicationResponse updateApplication(@Valid @RequestBody ApplicationRequest applicationRequest, @PathVariable int id) {
        return applicationService.updateApplication(applicationRequest, id);
    }
}
