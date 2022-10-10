package com.groupswd391.fall22.ProjectItem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectItemServiceImpl implements ProjectItemService {
    private ProjectItemRepository projectItemRepository;

    @Override
    public ResponseEntity<Map<String, Object>> getProjectItems(int page, int size) {
        try {
            List<ProjectItem> projectItems;
            Pageable paging = PageRequest.of(page, size);

            Page<ProjectItem> pageTuts;
            pageTuts = projectItemRepository.findAll(paging);

            projectItems = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("projectItems", projectItems);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ProjectItem addProjectItem(ProjectItem projectItem) {
        return projectItemRepository.save(projectItem);
    }

    @Override
    public ProjectItem deleteProjectItem(ProjectItem projectItem) {
        ProjectItem existingProjectItem = projectItemRepository.findById(projectItem.getId()).orElse(null);
        if (existingProjectItem != null) {
            existingProjectItem.setStatus(false);
            return projectItemRepository.save(existingProjectItem);
        }
        return null;
    }

    @Override
    public ProjectItem updateProjectItem(ProjectItem projectItem) {
        ProjectItem existingProjectItem = projectItemRepository.findById(projectItem.getId()).orElse(null);
        if (existingProjectItem != null) {
            existingProjectItem.setMin_price(projectItem.getMin_price());
            existingProjectItem.setMax_price(projectItem.getMax_price());
            existingProjectItem.setRequirement(projectItem.getRequirement());
            existingProjectItem.setNeededNum(projectItem.getNeededNum());
            existingProjectItem.setSoldNum(projectItem.getSoldNum());
            existingProjectItem.setAppliedNum(projectItem.getAppliedNum());
            return projectItemRepository.save(existingProjectItem);
        }
        return null;
    }
}