package com.groupswd391.fall22.Role;


import com.groupswd391.fall22.Role.DTO.RoleRequest;
import com.groupswd391.fall22.Role.DTO.RoleResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/roles")
public class
RoleController {

    final
    RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping
    ResponseEntity<Map<String, Object>> getRoles(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            return new ResponseEntity<>(roleService.getRoles(page, size), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
            summary = "Tạo 1 role mới ",
            description = "Tạo 1 role mới "
    )
    @PostMapping()
    RoleResponse addRole(@Valid @RequestBody RoleRequest roleRequest) {
        return roleService.createRole(roleRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteRole(@PathVariable int id) {
        if (roleService.deleteRole(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @Operation(
            summary = "Thay đổi thông tin major",
            description = "truyền id major muốn thay đổi"
    )
    @PutMapping("/{id}")
    RoleResponse updateRole(@Valid @RequestBody RoleRequest roleRequest, @PathVariable int id) {
        return roleService.updateRole(roleRequest, id);
    }
}
