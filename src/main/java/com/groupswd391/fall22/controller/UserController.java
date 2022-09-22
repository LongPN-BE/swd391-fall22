package com.groupswd391.fall22.controller;


import com.groupswd391.fall22.entity.User;
import com.groupswd391.fall22.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUser(){
        List<User> listUser = userRepository.findAll();
        if(listUser.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUserByID(@PathVariable("id") String id) {
        User user = userRepository.getUserById(id);
        if(user == null) {
            ResponseEntity.notFound().build();
        }
        return user;
    }

}

