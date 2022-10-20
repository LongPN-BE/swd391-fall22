package com.groupswd391.fall22.User;


import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequestLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController {

    final UserRepository userRepository;

    final
    UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public User findUserByID(@PathVariable int id) {
        User user = userRepository.getById(id);
        if (user == null) {
            ResponseEntity.notFound().build();
        }
        return user;
    }


    @GetMapping
    public ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String fullname,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Map<String, Object> response = userService.getUsers(fullname, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{major}")
    public ResponseEntity<Map<String, Object>> getUsersByMajor(
            @PathVariable(required = false) String major,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
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
}

