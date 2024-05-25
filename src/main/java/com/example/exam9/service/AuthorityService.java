package com.example.exam9.service;

import com.example.exam9.model.Authority;
import org.springframework.stereotype.Service;

@Service
public interface AuthorityService {
    Authority findById(Long id);

}
