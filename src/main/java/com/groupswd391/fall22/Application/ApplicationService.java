package com.groupswd391.fall22.Application;

import com.groupswd391.fall22.Application.DTO.ApplicationRequest;
import com.groupswd391.fall22.Application.DTO.ApplicationResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ApplicationService {

    ApplicationResponse createApplication(ApplicationRequest applicationRequest);
    ApplicationResponse updateApplication(ApplicationRequest applicationRequest, int id);
    boolean deleteApplication(int id);

    Map<String, Object> getApplications(int page, int size);
    Map<String, Object> getApplicationByUserID(int id, int page, int size);
    Map<String, Object> getApplicationByProjectItemID(int id, int page, int size);

}
