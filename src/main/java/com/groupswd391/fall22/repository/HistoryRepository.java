package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, String> {
}