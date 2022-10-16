package com.groupswd391.fall22.Role;


import com.groupswd391.fall22.Role.DTO.RoleRequest;
import com.groupswd391.fall22.Role.DTO.RoleResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RoleService {
    RoleResponse createRole(RoleRequest roleRequest);

    RoleResponse updateRole(RoleRequest roleRequest, int id);

    boolean deleteRole(int id);

    Map<String, Object> getRoles(int page, int size);
}
