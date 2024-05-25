package com.example.exam9.service;

import org.springframework.stereotype.Service;

@Service
public interface ProviderUsersService {

    Integer createUniqueAccount(Integer userId, Integer providerId);

    Integer getUniqueNumber(Integer personalAccountNumber, Integer providerId);
}
