package com.groupswd391.fall22.History.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryRequest {
    @NotNull
    private int historyTypeID;
    @NotNull
    private int userID;
    @NotNull
    private String description;
}
