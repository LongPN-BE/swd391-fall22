package com.groupswd391.fall22.HistoryType;

import com.groupswd391.fall22.HistoryType.DTO.HistoryTypeRequest;
import com.groupswd391.fall22.HistoryType.DTO.HistoryTypeResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface HistoryTypeService {

    HistoryTypeResponse createHistoryType(HistoryTypeRequest historyTypeRequest);
    HistoryTypeResponse updateHistoryType(HistoryTypeRequest historyTypeRequest, int id);
    boolean deleteHistoryType(int id);

    Map<String, Object> getHistoryType( int page, int size);

}
