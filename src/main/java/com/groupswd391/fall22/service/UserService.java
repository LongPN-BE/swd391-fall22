package com.groupswd391.fall22.service;


import com.groupswd391.fall22.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;


}
