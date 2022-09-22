package com.groupswd391.fall22.controller;


import com.groupswd391.fall22.entity.HistoryType;
import com.groupswd391.fall22.repository.HistoryTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryTypeController {

    @Autowired
    private HistoryTypeRepository historyTypeRepository;

    @RequestMapping(value = "/historyType/", method = RequestMethod.GET)
    public ResponseEntity<List<HistoryType>> listAllMajor(){
        List<HistoryType> listHistoryType = historyTypeRepository.findAll();
        if(listHistoryType.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<HistoryType>>(listHistoryType, HttpStatus.OK);
    }

}
