package com.groupswd391.fall22.Application;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApplicationServiceImpl implements ApplicationService {

final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Map<String, Object> getApplicationByUserID(int userID, int page, int size) {
        List<Application> applications;
        Pageable paging = PageRequest.of(page, size);
        Page<Application> pageTuts;
        if (userID == 0) {
            pageTuts = applicationRepository.findAll(paging);
        } else
            pageTuts = applicationRepository.findByUserID(userID, paging);
        applications = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("applications", applications);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
