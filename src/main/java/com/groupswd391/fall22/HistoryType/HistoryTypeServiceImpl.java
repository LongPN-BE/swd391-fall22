package com.groupswd391.fall22.HistoryType;

import com.groupswd391.fall22.HistoryType.DTO.HistoryTypeRequest;
import com.groupswd391.fall22.HistoryType.DTO.HistoryTypeResponse;
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
public class HistoryTypeServiceImpl implements HistoryTypeService {

    final
    HistoryTypeRepository historyTypeRepository;
    final
    ModelMapper modelMapper;

    public HistoryTypeServiceImpl(HistoryTypeRepository historyTypeRepository, ModelMapper modelMapper) {
        this.historyTypeRepository = historyTypeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public HistoryTypeResponse createHistoryType(HistoryTypeRequest historyTypeRequest) {
        HistoryType historyType = modelMapper.map(historyTypeRequest, HistoryType.class);
        historyType.setName(historyTypeRequest.getName());
        historyType.setDescription(historyTypeRequest.getDescription());
        HistoryType saveHistoryType = historyTypeRepository.save(historyType);
        return HistoryTypeResponse.buildFromHistoryType(saveHistoryType);
    }

    @Override
    public HistoryTypeResponse updateHistoryType(HistoryTypeRequest historyTypeRequest, int id) {
        HistoryType oldHistoryType = historyTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found History Type")
        );
        modelMapper.map(historyTypeRequest, oldHistoryType);
        oldHistoryType.setName(historyTypeRequest.getName());
        oldHistoryType.setDescription(historyTypeRequest.getDescription());
        HistoryType saveHistoryType = historyTypeRepository.save(oldHistoryType);
        return HistoryTypeResponse.buildFromHistoryType(saveHistoryType);
    }

    @Override
    public boolean deleteHistoryType(int id) {
        HistoryType historyType = historyTypeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found history Type")
        );
        historyTypeRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getHistoryType(String name, int page, int size) {
        List<HistoryType> historyTypes = null;
        Pageable paging = PageRequest.of(page, size);
        Page<HistoryType> pageTuts = null;
        if (name == null) {
            pageTuts = historyTypeRepository.findAll(paging);
        } else
//            pageTuts = historyTypeRepository.find(userID, paging);\
            pageTuts = historyTypeRepository.findAll(paging);
        historyTypes = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("historyType", historyTypes);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }
}
