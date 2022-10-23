package com.groupswd391.fall22.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT * FROM transaction t left join wallet w on w.id = t.wallet_id where wallet_id = ?", nativeQuery = true)
    Optional<Transaction> getTransactionByWallet(@Param("id") int id);

    @Query(value = "SELECT * FROM transaction t LEFT JOIN order o on o.id = t.oder_id where oder_id = ?", nativeQuery = true)
    Optional<Transaction> getTransactionByOrder(@Param("id") int id);

}