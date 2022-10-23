package com.groupswd391.fall22.History;

import com.groupswd391.fall22.Application.DTO.ApplicationRequest;
import com.groupswd391.fall22.History.DTO.HistoryRequest;
import com.groupswd391.fall22.History.DTO.HistoryResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface HistoryService {
    HistoryResponse createHistory(HistoryRequest historyRequest);
    HistoryResponse updateHistory(HistoryRequest historyRequest, int id);
    boolean deleteHistory(int id);

//    Map<String, Object> getHistory(int userID, int historyTypeID, int page, int size);

    Map<String, Object> getHistoryByUser(int userID, int page, int size);

}
