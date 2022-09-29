package com.groupswd391.fall22.User;


import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.User.UserRepository;
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
public class UserController {

    @Autowired
    private UserRepository userRepository;

//    @RequestMapping(value = "/user/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUser(){
//        List<User> listUser = userRepository.findAll();
//        if(listUser.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
//    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findUserByID(@PathVariable("id") String id) {
        User user = userRepository.getUserById(id);
        if(user == null) {
            ResponseEntity.notFound().build();
        }
        return user;
    }

    @GetMapping (produces = "application/json; charset=utf-8")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String firstname,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        try {
            List<User> users = new ArrayList<User>();
            Pageable paging = PageRequest.of(page, size);

            Page<User> pageTuts;

            if (firstname == null)
                pageTuts = userRepository.findAll(paging);
            else
                pageTuts = userRepository.findByFirstnameContaining(firstname, paging);

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
}

