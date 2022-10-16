package com.groupswd391.fall22.Major;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major, Integer> {

    Optional<Major> findByName(String name);

    Page<Major> findByNameContaining(String name, Pageable pagingSort);
}