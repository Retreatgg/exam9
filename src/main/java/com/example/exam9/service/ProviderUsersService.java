package com.example.exam9.service;

import org.springframework.stereotype.Service;

@Service
public interface ProviderUsersService {

    Integer createUniqueAccount(Integer userId, Long providerId);

    Integer getUniqueNumber(Integer personalAccountNumber, Long providerId);
}
