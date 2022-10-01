package com.groupswd391.fall22.User;

import com.groupswd391.fall22.Role.Role;
import com.groupswd391.fall22.User.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT e FROM User e WHERE e.id = :id")
    User getUserById(@Param("id") String id);

//    Page<User> findByFullContaining(String firstname, Pageable pagingSort);

    Optional<User> findByEmail(String email);


}