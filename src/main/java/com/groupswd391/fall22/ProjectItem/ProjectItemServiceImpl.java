package com.groupswd391.fall22.projectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProjectItemServiceImpl implements ProjectItemService {
    @Autowired
    private ProjectItemRepository projectItemRepository;

    @Override
    public List<ProjectItem> getProjectItems(int projectID, Pageable pageable) {
        List<ProjectItem> resultList = projectItemRepository.getProjectItemsList(projectID);
        return resultList;
    }

    @Override
    public Optional<ProjectItem> getProjectItemById(int id) {
        return Optional.ofNullable(projectItemRepository.getItem(id));
    }

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
    public void deleteProjectItem(ProjectItem projectItem) {
        ProjectItem existingProjectItem = projectItemRepository.findById(projectItem.getId()).orElse(null);
        if (existingProjectItem != null) {
            existingProjectItem.setStatus(3);
            projectItemRepository.save(existingProjectItem);
        }
    }

    @Override
    public ProjectItem updateProjectItem(ProjectItem projectItem) {
        ProjectItem existingProjectItem = projectItemRepository.findById(projectItem.getId()).orElse(null);
        if (existingProjectItem != null) {
            existingProjectItem.setMinPrice(projectItem.getMinPrice());
            existingProjectItem.setMaxPrice(projectItem.getMaxPrice());
            existingProjectItem.setRequirement(projectItem.getRequirement());
            existingProjectItem.setNeededNum(projectItem.getNeededNum());
            existingProjectItem.setSoldNum(projectItem.getSoldNum());
            existingProjectItem.setAppliedNum(projectItem.getAppliedNum());
            return projectItemRepository.save(existingProjectItem);
        }
        return null;
    }
}
