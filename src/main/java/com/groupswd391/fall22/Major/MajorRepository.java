package com.groupswd391.fall22.Major;

import com.groupswd391.fall22.Major.Major;
import com.groupswd391.fall22.Role.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<Major, String> {

    Optional<Major> findByName(String name);

    Page<Major> findByNameContaining(String name, Pageable pagingSort);
}