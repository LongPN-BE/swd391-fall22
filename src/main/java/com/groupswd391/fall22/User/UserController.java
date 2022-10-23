package com.groupswd391.fall22.User;


import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequestLogin;
import com.groupswd391.fall22.User.DTO.UserDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserByID(@PathVariable int id) {
        return userService.getUserById(id);
    }


    @GetMapping
    public ResponseEntity<Map<String, Object>> getUsers(@RequestParam(required = false) String fullname, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = userService.getUsers(fullname, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/major/{major}")
    public ResponseEntity<Map<String, Object>> getUsersByMajor(@RequestParam(required = false) String major, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = userService.getUsersByMajor(major, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody @Valid UserDtoRequestLogin request) {
        return userService.Login(request);
    }

    @PostMapping("/loginfirebase/{token}")
    ResponseEntity<?> loginFireBase(@RequestParam String token) {
        return userService.LoginFireBase(token);
    }

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody @Valid UserDtoRequest request) {
        return userService.Register(request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteUser(@PathVariable int id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.OK);
        }
        return new ResponseEntity<>("DELETE SUCCESSFULLY", null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    UserDtoResponse updateUser(@Valid @RequestBody UserDtoRequest userDtoRequest, @PathVariable int id) {
        return userService.updateUser(userDtoRequest, id);
    }
}

