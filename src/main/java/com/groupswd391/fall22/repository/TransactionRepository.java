package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}