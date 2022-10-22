package com.groupswd391.fall22.Wallet;

import com.groupswd391.fall22.Wallet.dto.WalletRequest;
import com.groupswd391.fall22.Wallet.dto.WalletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface WalletService {
    WalletResponse createWallet(WalletRequest walletRequest);

    WalletResponse updateWallet(WalletRequest walletRequest, int id);

    ResponseEntity<?> getWalletById(int id);

    ResponseEntity<?> getWalletByUser(int id);

    boolean deleteWallet(int id);

    Map<String, Object> getWallets(int page, int size);
}
