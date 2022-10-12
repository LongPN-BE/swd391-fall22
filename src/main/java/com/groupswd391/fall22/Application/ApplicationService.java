package com.groupswd391.fall22.Application;

import com.groupswd391.fall22.Application.DTO.ApplicationDTORequest;
import com.groupswd391.fall22.User.DTO.UserDtoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ApplicationService {

    ResponseEntity<?> createApplication(ApplicationDTORequest applicationDTORequest);

    Map<String, Object> getApplicationByUserID(int userID, int page, int size);
}
