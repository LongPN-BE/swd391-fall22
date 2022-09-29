package com.groupswd391.fall22.Application;

import com.groupswd391.fall22.Application.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, String> {
}