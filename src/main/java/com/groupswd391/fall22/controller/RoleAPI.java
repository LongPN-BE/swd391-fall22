package com.groupswd391.fall22.controller;


import com.groupswd391.fall22.entity.Role;
import com.groupswd391.fall22.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleAPI {

    @Autowired
    RoleRepository contactService;

    @RequestMapping(value = "/role/", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> listAllContact(){
        List<Role> listRole= contactService.findAll();
        if(listRole.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Role>>(listRole, HttpStatus.OK);
    }

}
