package com.groupswd391.fall22.HistoryType.DTO;

import com.groupswd391.fall22.History.DTO.HistoryResponse;
import com.groupswd391.fall22.HistoryType.HistoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryTypeResponse {
    private int id;
    private String name;
    private String description;

    public static HistoryTypeResponse buildFromHistoryType(HistoryType historyType) {
        return new HistoryTypeResponse(
                historyType.getId(),
                historyType.getName(),
        historyType.getDescription()
        );
    }
}
