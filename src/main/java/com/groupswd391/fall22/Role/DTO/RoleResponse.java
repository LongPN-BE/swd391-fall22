package com.groupswd391.fall22.Role.DTO;


import com.groupswd391.fall22.Role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {
    private int id;
    private String name;
    private String description;

    public static RoleResponse buildFromRole(Role role) {
        return new RoleResponse(
                role.getId(),
                role.getName(),
                role.getDescription()
        );
    }
}
