package com.groupswd391.fall22.Wallet;

import com.groupswd391.fall22.Wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}