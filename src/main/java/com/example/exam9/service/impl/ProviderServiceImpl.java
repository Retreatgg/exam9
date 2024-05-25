package com.example.exam9.service.impl;


import com.example.exam9.dto.ProviderDto;
import com.example.exam9.model.Provider;
import com.example.exam9.repository.ProviderRepository;
import com.example.exam9.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Override
    public List<ProviderDto> getProviders() {
        List<Provider> providers = providerRepository.findAll();
        List<ProviderDto> list = new ArrayList<>();
        providers.forEach(p -> {
            list.add(ProviderDto.builder()
                    .name(p.getName())
                    .build());
        });
        return list;
    }
}
