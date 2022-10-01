package com.groupswd391.fall22.User;

import java.util.Optional;

import com.groupswd391.fall22.Role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getById(long id);
}
