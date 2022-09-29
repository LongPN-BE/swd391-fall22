package com.groupswd391.fall22.Transaction;

import com.groupswd391.fall22.Transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}