package com.example.exam9.service.impl;


import com.example.exam9.dto.ProviderDto;
import com.example.exam9.model.Provider;
import com.example.exam9.repository.ProviderRepository;
import com.example.exam9.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
                    .account(String.valueOf(p.getAccount()))
                    .name(p.getName())
                    .build());
        });
        return list;
    }

    @Override
    public ProviderDto getProviderById(Integer id) {
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Provider is not found"));
        return ProviderDto.builder()
                .account(provider.getAccount().toString())
                .name(provider.getName())
                .build();
    }

}
