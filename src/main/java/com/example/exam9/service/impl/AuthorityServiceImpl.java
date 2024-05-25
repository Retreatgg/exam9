package com.example.exam9.service.impl;

import com.example.exam9.model.Authority;
import com.example.exam9.repository.AuthorityRepository;
import com.example.exam9.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public Authority findById(Long id) {
        return authorityRepository.findById(id).get();
    }
}
