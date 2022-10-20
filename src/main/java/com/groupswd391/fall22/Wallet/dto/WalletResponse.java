package com.groupswd391.fall22.Wallet.dto;


import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.Wallet.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponse {
private int id;
private User user;
private String name;
private double amount;


    public static WalletResponse buildFromWallet(Wallet wallet) {
        return new WalletResponse(
                wallet.getId(),
                wallet.getUser(),
                wallet.getName(),
                wallet.getAmount()
        );
    }
}
