package com.groupswd391.fall22.History.DTO;

import com.groupswd391.fall22.History.History;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponse {
    private int id;
    private int historyTypeID;
    private int userID;
    private String description;

    public static HistoryResponse buildFromHistory(History history) {
        return new HistoryResponse(
                history.getId(),
                history.getHistoryType().getId(),
                history.getUser().getId(),
                history.getDescription()
        );
    }
}
