package com.example.exam9.service;

import com.example.exam9.dto.UserCreateDto;
import com.example.exam9.model.User;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

@Service
public interface UserService {
    void register(UserCreateDto userDto, HttpServletRequest request);
    User getByResetPasswordToken(String token);

    void makeResetPasswdLink(HttpServletRequest request) throws UsernameNotFoundException, UnsupportedEncodingException, MessagingException;

    void updatePassword(User user, String password);

    Locale getUserLocale(String selectedLanguage);
}
