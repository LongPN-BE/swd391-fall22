package com.groupswd391.fall22.Transaction.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
    @NotNull
    private int orderID;
    @NotNull
    private int walletId;
}
