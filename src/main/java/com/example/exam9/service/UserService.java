package com.example.exam9.service;

import com.example.exam9.dto.TopUpAccountDto;
import com.example.exam9.dto.UserCreateDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public interface UserService {
    void register(UserCreateDto userDto, HttpServletRequest request);

    Locale getUserLocale(String selectedLanguage);

    void topUpAccount(TopUpAccountDto topUpAccountDto);
}
