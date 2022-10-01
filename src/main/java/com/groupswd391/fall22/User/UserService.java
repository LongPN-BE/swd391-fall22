package com.groupswd391.fall22.User;

import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequestLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<?> Login(UserDtoRequestLogin userDtoRequestLogin);
    ResponseEntity<?> Register(UserDtoRequest userDtoRequest);


}
