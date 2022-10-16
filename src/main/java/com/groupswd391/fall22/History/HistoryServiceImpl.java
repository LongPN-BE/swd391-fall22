package com.groupswd391.fall22.History;


import com.groupswd391.fall22.History.DTO.HistoryRequest;
import com.groupswd391.fall22.History.DTO.HistoryResponse;
import com.groupswd391.fall22.HistoryType.HistoryType;
import com.groupswd391.fall22.HistoryType.HistoryTypeRepository;
import com.groupswd391.fall22.User.User;
import com.groupswd391.fall22.User.UserRepository;
import com.groupswd391.fall22.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HistoryServiceImpl implements HistoryService{

    final
    ModelMapper modelMapper;
    final
    UserRepository userRepository;
    final
    HistoryRepository historyRepository;
    final
    HistoryTypeRepository historyTypeRepository;

    public HistoryServiceImpl(ModelMapper modelMapper, UserRepository userRepository, HistoryRepository historyRepository, HistoryTypeRepository historyTypeRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.historyRepository = historyRepository;
        this.historyTypeRepository = historyTypeRepository;
    }

    @Override
    public HistoryResponse createHistory(HistoryRequest historyRequest) {
        History history = modelMapper.map(historyRequest,History.class);
        User user = userRepository.findById(historyRequest.getUserID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found user")
        );
        HistoryType historyType = historyTypeRepository.findById(historyRequest.getHistoryTypeID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found history type")
        );
        history.setHistoryType(historyType);
        history.setUser(user);
        history.setDescription(historyRequest.getDescription());

        History saveHistory= historyRepository.save(history);

        return HistoryResponse.buildFromHistory(saveHistory);
    }

    @Override
    public HistoryResponse updateHistory(HistoryRequest historyRequest, int id) {
        History oldHistory= historyRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Not found History")
        );
        User user = userRepository.findById(historyRequest.getUserID()).orElseThrow(
                () -> new ResourceNotFoundException("Not found user")
        );
        HistoryType historyType = historyTypeRepository.findById(historyRequest.getHistoryTypeID()).orElseThrow(
                ()-> new ResourceNotFoundException("Not found history Type")
        );
        modelMapper.map(historyRequest,oldHistory);
        oldHistory.setHistoryType(historyType);
        oldHistory.setUser(user);
        oldHistory.setDescription(historyRequest.getDescription());

        History saveHistory= historyRepository.save(oldHistory);

        return HistoryResponse.buildFromHistory(saveHistory);
    }

    @Override
    public boolean deleteHistory(int id) {
        History history = historyRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found history")
        );
        historyRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getHistory(int userID, int historyTypeID, int page, int size) {
        List<History> histories = null;
        Pageable paging = PageRequest.of(page, size);
        Page<History> pageTuts = null;
//        if (userID == 0) {
//            pageTuts = historyRepository.findAll(paging);
//        } else
//            pageTuts = historyRepository.find(userID, paging);
            pageTuts = historyRepository.findAll(paging);
        histories = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("histories", histories);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
