package com.groupswd391.fall22.User;

import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequestLogin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ResponseEntity<?> Login(UserDtoRequestLogin userDtoRequestLogin);
    ResponseEntity<?> Register(UserDtoRequest userDtoRequest);

}
