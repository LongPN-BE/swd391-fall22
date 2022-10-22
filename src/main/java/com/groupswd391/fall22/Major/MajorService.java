package com.groupswd391.fall22.Major;

import com.groupswd391.fall22.Major.DTO.MajorRequest;
import com.groupswd391.fall22.Major.DTO.MajorResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface MajorService {
    MajorResponse createMajor(MajorRequest majorRequest);

    MajorResponse updateMajor(MajorRequest majorRequest, int id);

    boolean deleteMajor(int id);

    Map<String, Object> getMajors(int page, int size);

    Optional<Major> getMajorByID(int id);

}
