package com.groupswd391.fall22.User;

import com.groupswd391.fall22.Transaction.DTO.TransactionRequest;
import com.groupswd391.fall22.Transaction.DTO.TransactionResponse;
import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequestLogin;
import com.groupswd391.fall22.User.DTO.UserDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public interface UserService {
    ResponseEntity<?> Login(UserDtoRequestLogin userDtoRequestLogin);

    ResponseEntity<?> LoginFireBase(String token);

    ResponseEntity<?> Register(UserDtoRequest userDtoRequest);

    Map<String, Object> getUsers(String fullname, int page, int size);

    Map<String, Object> getUsersByMajor(String major, int page, int size);

    ResponseEntity<?> getUserById(int id);

    boolean deleteUser(int id);

    User getUsersByID(int userID);

    UserDtoResponse updateUser(UserDtoRequest userDtoRequest, int id);
}
