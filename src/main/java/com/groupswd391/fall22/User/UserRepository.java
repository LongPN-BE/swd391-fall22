package com.groupswd391.fall22.User;

import com.groupswd391.fall22.User.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT e FROM User e WHERE e.id = :id")
    User getUserById(@Param("id") String id);

    @Query(value="SELECT e FROM User e WHERE e.firstname Like :name or e.lastname = :name", nativeQuery = true)
    List<User> getUserByName(@Param("name") String name);

    Page<User> findByFirstnameContaining(String firstname, Pageable pagingSort);
}