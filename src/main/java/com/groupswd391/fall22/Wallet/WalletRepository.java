package com.groupswd391.fall22.Wallet;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    @Query(value = "SELECT * FROM wallet e LEFT JOIN user u on e.user_id = u.id where u.id = ?", nativeQuery = true)
    Optional<Wallet> getWalletByUser(@Param("id") int id);
}