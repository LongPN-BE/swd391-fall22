package com.groupswd391.fall22.Major;

import com.groupswd391.fall22.Major.DTO.MajorRequest;
import com.groupswd391.fall22.Major.DTO.MajorResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class MajorServiceImpl implements MajorService {
    final MajorRepository majorRepository;
    final ModelMapper modelMapper;

    public MajorServiceImpl(MajorRepository majorRepository, ModelMapper modelMapper) {
        this.majorRepository = majorRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public MajorResponse createMajor(MajorRequest majorRequest) {
        Major major = modelMapper.map(majorRequest, Major.class);
        major.setName(majorRequest.getName());
        major.setDescription(majorRequest.getDescription());
        Major saveMajor = majorRepository.save(major);
        return MajorResponse.buildFromMajor(saveMajor);
    }

    @Override
    public MajorResponse updateMajor(MajorRequest majorRequest, int id) {
        Major oldMajor = majorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Major")
        );
        modelMapper.map(majorRequest, oldMajor);
        oldMajor.setName(majorRequest.getName());
        oldMajor.setDescription(majorRequest.getDescription());
        Major saveMajor = majorRepository.save(oldMajor);
        return MajorResponse.buildFromMajor(saveMajor);
    }

    @Override
    public boolean deleteMajor(int id) {
        Major major = majorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found Major")
        );
        majorRepository.deleteById(id);
        return true;
    }

    @Override
    public Map<String, Object> getMajors(int page, int size) {
        List<Major> majors = null;
        Pageable paging = PageRequest.of(page, size);
        Page<Major> pageTuts = null;
        pageTuts = majorRepository.findAll(paging);
        majors = pageTuts.getContent();

        Map<String, Object> response = new HashMap<>();
        response.put("majors", majors);
        response.put("currentPage", pageTuts.getNumber());
        response.put("totalItems", pageTuts.getTotalElements());
        response.put("totalPages", pageTuts.getTotalPages());
        return response;
    }

    @Override
    public Optional<Major> getMajorByID(int id) {
        return Optional.ofNullable(majorRepository.getMajorByID(id));
    }
}
