package com.groupswd391.fall22.Application.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @NotNull
    private int projectItemID;
    @NotNull
    private int userID;
    @NotNull
    private int userRequestID;
    @NotNull
    private String requirement;
    @NotNull
    private double price;
    @NotNull
    private Date time = (Date) new java.util.Date();
}
