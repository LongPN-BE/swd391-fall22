package com.groupswd391.fall22.repository;

import com.groupswd391.fall22.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}