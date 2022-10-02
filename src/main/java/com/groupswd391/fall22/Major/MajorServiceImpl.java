package com.groupswd391.fall22.Major;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MajorServiceImpl implements MajorService {

    final MajorRepository majorRepository;

    public MajorServiceImpl(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    @Override
    public List<Major> getList() {
        List<Major> list = majorRepository.findAll();
        if(list.isEmpty()){
            System.out.println("Is empty List");
        }
        return list;
    }
}
