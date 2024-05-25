package com.example.exam9.service.impl;

import com.example.exam9.dto.TopUpAccountDto;
import com.example.exam9.dto.UserCreateDto;
import com.example.exam9.model.Authority;
import com.example.exam9.model.User;
import com.example.exam9.repository.UserRepository;
import com.example.exam9.service.AuthorityService;
import com.example.exam9.service.EmailService;
import com.example.exam9.service.UniqueNumberService;
import com.example.exam9.service.UserService;
import com.example.exam9.util.UserUtil;
import com.example.exam9.util.Utility;
import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.LocaleUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final AuthorityService authorityService;
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UniqueNumberService uniqueNumberService;
    private final UserUtil userUtil;

    @Override
    public void register(UserCreateDto userCreateDto, HttpServletRequest request) {

        User user = User.builder()
                .personalAccountNumber(uniqueNumberService.generateUniqueNumber())
                .amountMoney(1000.0)
                .enabled(true)
                .password(encoder.encode(userCreateDto.getPassword()))
                .username(userCreateDto.getUsername())
                .accountTypeId(1L)
                .build();

        userRepository.save(user);
        user.setAuthorities(setAuthoritiesUser(user.getPersonalAccountNumber()));

        try {
            request.login(userCreateDto.getUsername(), userCreateDto.getPassword());
        } catch (ServletException e) {
            log.error(e.getMessage());
        }
    }


    private List<Authority> setAuthoritiesUser(Integer personalAccountNumber) {
        List<Long> roles = findRolesByPersonalAccountNumber(personalAccountNumber);
        List<Authority> authorities = new ArrayList();
        roles.forEach(u -> {
            authorities.add(authorityService.findById(u));
        });

        return authorities;
    }

    private List<Long> findRolesByPersonalAccountNumber(Integer personalAccountNumber) {
        return userRepository.findRolesByPersonalAccountNumber(personalAccountNumber);
    }


    @Override
    public User getByResetPasswordToken(String token) {
        return userRepository.findByResetPasswordToken(token).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        String encodedPassword = encoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.saveAndFlush(user);
    }

    @Override
    public Locale getUserLocale(String selectedLanguage) {
        return LocaleUtils.toLocale(selectedLanguage);
    }

    @Override
    public void topUpAccount(TopUpAccountDto topUpAccountDto) {
        User user = userRepository.findByPersonalAccountNumber(topUpAccountDto.getAccountNumber()).get();
        user.setAmountMoney(user.getAmountMoney() + topUpAccountDto.getAmount());
        userRepository.save(user);
    }


    @Override
    public void makeResetPasswdLink(HttpServletRequest request) throws UsernameNotFoundException, UnsupportedEncodingException, MessagingException {
        String email = request.getParameter("email");
        String token = UUID.randomUUID().toString();
        updateResetPasswordToken(token, Integer.parseInt(email));
        String passwordLink = Utility.getSiteURL(request) + "/auth/reset_password?token=" + token;
        emailService.sendEmail(email, passwordLink);
    }


    private void updateResetPasswordToken(String token, Integer number) {
        User user = userRepository.findByPersonalAccountNumber(number).orElseThrow(() -> new UsernameNotFoundException("Could not find any user with the email " + number));
        user.setResetPasswordToken(token);
        userRepository.saveAndFlush(user);
    }



}
