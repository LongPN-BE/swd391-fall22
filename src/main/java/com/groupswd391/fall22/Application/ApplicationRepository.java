package com.groupswd391.fall22.Application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(value = "SELECT a from Application a inner join User u on a.user.id = u.id" +
            " inner join ProjectItem p on a.projectItem.id = p.id" +
            " where a.user.id = :user_ID")
    Page<Application> findByUserID(int user_ID, Pageable pagingSort);
}