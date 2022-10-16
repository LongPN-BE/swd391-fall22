package com.groupswd391.fall22.Role;


import com.groupswd391.fall22.Role.DTO.RoleRequest;
import com.groupswd391.fall22.Role.DTO.RoleResponse;
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
public class RoleServiceImpl implements RoleService {

    final
    RoleRepository roleRepository;
    final
    ModelMapper modelMapper;

    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RoleResponse createRole(RoleRequest roleRequest) {
        Role role = modelMapper.map(roleRequest, Role.class);
        role.setName(roleRequest.getName());
        role.setDescription(roleRequest.getDescription());
        Role saveRole = roleRepository.save(role);
        return RoleResponse.buildFromRole(saveRole);
    }

    @Override
    public RoleResponse updateRole(RoleRequest roleRequest, int id) {
        Role oldRole = roleRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Role")
        );
        modelMapper.map(roleRequest, oldRole);
        oldRole.setName(roleRequest.getName());
        oldRole.setDescription(roleRequest.getDescription());
        Role saveRole = roleRepository.save(oldRole);
        return RoleResponse.buildFromRole(saveRole);
    }

    @Override
    public boolean deleteRole(int id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Role")
        );
        roleRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getRoles(int page, int size) {
        List<Role> roles = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Role> pageTuts = null;
        pageTuts = roleRepository.findAll(paging);
        roles = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("roles", roles);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
