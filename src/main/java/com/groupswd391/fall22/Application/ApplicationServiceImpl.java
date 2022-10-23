package com.groupswd391.fall22.Application;


import com.groupswd391.fall22.Application.DTO.ApplicationRequest;
import com.groupswd391.fall22.Application.DTO.ApplicationResponse;
import com.groupswd391.fall22.ProjectItem.ProjectItem;
import com.groupswd391.fall22.ProjectItem.ProjectItemRepository;
import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.User.UserRepository;
import com.groupswd391.fall22.Wallet.Wallet;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApplicationServiceImpl implements ApplicationService {

    final
    ApplicationRepository applicationRepository;
    final
    ModelMapper modelMapper;
    final
    UserRepository userRepository;
    final
    ProjectItemRepository projectItemRepository;


    public ApplicationServiceImpl(ApplicationRepository applicationRepository, ModelMapper modelMapper, UserRepository userRepository, ProjectItemRepository projectItemRepository) {
        this.applicationRepository = applicationRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.projectItemRepository = projectItemRepository;
    }


    @Override
    public ApplicationResponse createApplication(ApplicationRequest applicationRequest) {
        Application application = modelMapper.map(applicationRequest,Application.class);
        User user = userRepository.findById(applicationRequest.getUserID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found user")
        );
        User userRequest = userRepository.findById(applicationRequest.getUserRequestID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found user request")
        );
        ProjectItem projectItem = projectItemRepository.findById(applicationRequest.getProjectItemID()).orElseThrow(
                ()-> new ResourceNotFoundException("Not found projectItem")
        );
        application.setProjectItem(projectItem);
        application.setUser(user);
        application.setUserRequest(userRequest);
        application.setRequirement(applicationRequest.getRequirement());
        application.setPrice(applicationRequest.getPrice());
        application.setTime(applicationRequest.getTime());

        Application saveApplication= applicationRepository.save(application);

        return ApplicationResponse.buildFromApplication(saveApplication);
    }

    @Override
    public ApplicationResponse updateApplication(ApplicationRequest applicationRequest, int id) {
        Application oldApplication= applicationRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found Application")
        );
        User user = userRepository.findById(applicationRequest.getUserID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found user")
        );
        User userRequest = userRepository.findById(applicationRequest.getUserRequestID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found user request")
        );
        ProjectItem projectItem = projectItemRepository.findById(applicationRequest.getProjectItemID()).orElseThrow(
                ()-> new ResourceNotFoundException("Not found projectItem")
        );
        modelMapper.map(applicationRequest,oldApplication);
        oldApplication.setProjectItem(projectItem);
        oldApplication.setUser(user);
        oldApplication.setUserRequest(userRequest);
        oldApplication.setRequirement(applicationRequest.getRequirement());
        oldApplication.setPrice(applicationRequest.getPrice());
        oldApplication.setTime(applicationRequest.getTime());

        Application saveApplication= applicationRepository.save(oldApplication);

        return ApplicationResponse.buildFromApplication(saveApplication);
    }

    @Override
    public boolean deleteApplication(int id) {
        Application application = applicationRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found application")
        );
        applicationRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getApplications(int page, int size) {
        List<Application> applications = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Application> pageTuts = null;
        pageTuts = applicationRepository.findApplications(paging);
        applications = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("applications", applications);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> getApplicationByUserID(int id, int page, int size) {
        List<Application> applications = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Application> pageTuts = null;
        pageTuts = applicationRepository.findByUserID(id, paging);
        applications = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("applications", applications);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> getApplicationByProjectItemID(int id, int page, int size) {
        List<Application> applications = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Application> pageTuts = null;
        pageTuts = applicationRepository.findByProjectItem(id, paging);
        applications = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("applications", applications);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
