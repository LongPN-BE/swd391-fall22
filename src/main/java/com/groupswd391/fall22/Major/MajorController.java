package com.groupswd391.fall22.Major;


import com.groupswd391.fall22.Major.DTO.MajorRequest;
import com.groupswd391.fall22.Major.DTO.MajorResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/majors")
public class MajorController {

    final
    MajorService majorService;

    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @RequestMapping(value = "/majors", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            return new ResponseEntity<>(majorService.getMajors(page, size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 major mới ",
            description = "Tạo 1 major mới "
    )
    @PostMapping()
    MajorResponse addMajor(@Valid @RequestBody MajorRequest majorRequest) {
        return majorService.createMajor(majorRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteMajor(@PathVariable int id) {
        if (majorService.deleteMajor(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin major",
            description = "truyền id major muốn thay đổi"
    )
    @PutMapping("/{id}")
    MajorResponse updateMajor(@Valid @RequestBody MajorRequest majorRequest, @PathVariable int id) {
        return majorService.updateMajor(majorRequest, id);
    }

}
