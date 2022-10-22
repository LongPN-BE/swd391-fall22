package com.groupswd391.fall22.Major;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major, Integer> {

    Optional<Major> findByName(String name);

    Page<Major> findByNameContaining(String name, Pageable pagingSort);

    @Query(value = "SELECT * FROM major m WHERE m.id = :id", nativeQuery = true)
    Major getMajorByID(@Param("id") int id);
}