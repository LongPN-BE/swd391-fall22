package com.groupswd391.fall22.Order.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTORequest {

    @NotNull
    private int applicationID;
    @NotNull
    private Date time;
    @NotNull
    private double ammount;

    private boolean status;
}
