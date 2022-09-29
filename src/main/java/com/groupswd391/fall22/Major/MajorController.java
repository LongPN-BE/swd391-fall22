package com.groupswd391.fall22.Major;

import com.groupswd391.fall22.Major.Major;
import com.groupswd391.fall22.Major.MajorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MajorController {

    @Autowired
    private MajorRepository majorRepository;

    @RequestMapping(value = "/major/", method = RequestMethod.GET)
    public ResponseEntity<List<Major>> listAllMajor(){
        List<Major> listMajor = majorRepository.findAll();
        if(listMajor.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Major>>(listMajor, HttpStatus.OK);
    }

}
