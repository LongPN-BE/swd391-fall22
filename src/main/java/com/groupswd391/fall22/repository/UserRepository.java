package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT e FROM User e WHERE e.id = :id")
    User getUserById(@Param("id") String id);
}