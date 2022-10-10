package com.groupswd391.fall22.OrderDetail.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTORequest {
    @NotNull
    private int orderID;
    @NotNull
    private int projectitemID;
}
