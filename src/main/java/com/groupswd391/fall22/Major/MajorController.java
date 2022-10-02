package com.groupswd391.fall22.Major;


import com.groupswd391.fall22.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MajorController {

    @Autowired
    MajorRepository majorRepository;

    @RequestMapping(value = "/majors", method = RequestMethod.GET)
    ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<Major> majors = new ArrayList<Major>();
            Pageable paging = PageRequest.of(page, size);

            Page<Major> pageTuts;

            if (name == null)
                pageTuts = majorRepository.findAll(paging);
            else
                pageTuts = majorRepository.findByNameContaining(name, paging);

            majors = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("majors", majors);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
