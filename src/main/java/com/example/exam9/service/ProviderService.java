package com.example.exam9.service;

import com.example.exam9.dto.ProviderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProviderService {

    List<ProviderDto> getProviders();
    ProviderDto getProviderById(Integer id);

}
