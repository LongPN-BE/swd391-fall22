package com.groupswd391.fall22.Wallet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WalletDTORequest {
    @NotNull
    private int userID;
    @NotNull
    private String name;
    @NotNull
    private double amount;
}
