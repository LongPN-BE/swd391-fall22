package com.groupswd391.fall22.Role;

import com.groupswd391.fall22.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findByName(String name);
}
