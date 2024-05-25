package com.example.exam9.service.impl;

import com.example.exam9.model.UniqueNumber;
import com.example.exam9.repository.UniqueNumberRepository;
import com.example.exam9.service.UniqueNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniqueNumberServiceImpl implements UniqueNumberService {

    private final UniqueNumberRepository uniqueNumberRepository;

    @Override
    public int generateUniqueNumber() {
        int uniqueNumber;
        do {
            uniqueNumber = (int) (Math.random() * 900000) + 100000;
        } while (uniqueNumberRepository.existsByUniqueNumber(uniqueNumber));
        UniqueNumber entity = new UniqueNumber();
        entity.setUniqueNumber(uniqueNumber);
        uniqueNumberRepository.save(entity);
        return uniqueNumber;
    }
}
