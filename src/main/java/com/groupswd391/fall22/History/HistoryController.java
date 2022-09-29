package com.groupswd391.fall22.History;

import com.groupswd391.fall22.History.History;
import com.groupswd391.fall22.History.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HistoryController {
    @Autowired
    HistoryRepository historyRepository;

    @RequestMapping(value = "/histories/", method = RequestMethod.GET)
    public ResponseEntity<List<History>> listAllHistories(){
        List<History> listHistories = historyRepository.findAll();
        if(listHistories.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<History>>(listHistories, HttpStatus.OK);
    }
}
