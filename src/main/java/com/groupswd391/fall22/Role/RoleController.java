package com.groupswd391.fall22.Role;


import com.groupswd391.fall22.Role.Role;
import com.groupswd391.fall22.Role.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class RoleController {

    @Autowired
    RoleRepository roleRepository;


    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<Role> roles = new ArrayList<Role>();
            Pageable paging = PageRequest.of(page, size);

            Page<Role> pageTuts;

            if (name == null)
                pageTuts = roleRepository.findAll(paging);
            else
                pageTuts = roleRepository.findByNameContaining(name, paging);

            roles = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("roles", roles);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
