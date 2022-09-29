package com.groupswd391.fall22.User;


import com.groupswd391.fall22.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;


}
