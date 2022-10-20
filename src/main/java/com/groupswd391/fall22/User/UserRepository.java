package com.groupswd391.fall22.User;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT e FROM User e WHERE e.id = :id")
    User getUserById(@Param("id") int id);

    @Query("SELECT e FROM User e WHERE e.email = :email")
    User getUserByEmail(@Param("email") String email);

    Page<User> findByFullnameContaining(String fullname, Pageable pagingSort);

    @Query(value = "select u from User u inner join Major m on u.major.id = m.id" +
            " where u.major.name = :major ")
    Page<User> findByMajor(@Param("major") String major, Pageable pagingSort);

    Optional<User> findByEmail(String email);


}