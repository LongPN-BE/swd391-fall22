package com.groupswd391.fall22.Application;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ApplicationService {

    Map<String, Object> getApplicationByUserID(int userID, int page, int size);
}
