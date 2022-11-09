package com.groupswd391.fall22.Application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    @Query(value = "SELECT * from application a left join user u on u.id = a.user_ID where u.id = ?", nativeQuery = true)
    Page<Application> findByUserID(int id, Pageable pagingSort);

    @Query(value = "SELECT * from application a left join project_item pi on pi.id = a.project_item_id where pi.id = ?", nativeQuery = true)
    Page<Application> findByProjectItem(int id, Pageable pagingSort);


    @Query(value = "SELECT * from application", nativeQuery = true)
    Page<Application> findApplications(Pageable pagingSort);
}