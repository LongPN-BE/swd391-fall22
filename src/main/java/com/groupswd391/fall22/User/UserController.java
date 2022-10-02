package com.groupswd391.fall22.User;


import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequestLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUserByID(@PathVariable("id") int id) {
        User user = userRepository.getUserById(id);
        if(user == null) {
            ResponseEntity.notFound().build();
        }
        return user;
    }

    @GetMapping (produces = "application/json; charset=utf-8")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String fullname,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<User> users = new ArrayList<User>();
            Pageable paging = PageRequest.of(page, size);

            Page<User> pageTuts;

            if (fullname == null)
                pageTuts = userRepository.findAll(paging);
            else
                pageTuts = userRepository.findByFullnameContaining(fullname, paging);

            users = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("accounts", users);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody @Valid UserDtoRequestLogin request) {
        return userService.Login(request);
    }
    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody @Valid UserDtoRequest request) {
        return userService.Register(request);
    }
}

