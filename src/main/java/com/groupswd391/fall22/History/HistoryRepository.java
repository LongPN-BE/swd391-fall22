package com.groupswd391.fall22.History;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Query(value = "SELECT * from history LEFT JOIN user u on history.user_id = u.id where u.id = ? ", nativeQuery = true)
    Page<History> findHistoriesByUser(int id, Pageable pagingSort);

}