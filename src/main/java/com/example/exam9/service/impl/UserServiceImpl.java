package com.example.exam9.service.impl;

import com.example.exam9.dto.TopUpAccountDto;
import com.example.exam9.dto.UserCreateDto;
import com.example.exam9.model.Authority;
import com.example.exam9.model.User;
import com.example.exam9.repository.UserRepository;
import com.example.exam9.service.AuthorityService;
import com.example.exam9.service.UniqueNumberService;
import com.example.exam9.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.LocaleUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;
    private final AuthorityService authorityService;
    private final UserRepository userRepository;
    private final UniqueNumberService uniqueNumberService;

    @Override
    public void register(UserCreateDto userCreateDto, HttpServletRequest request) {
        Integer uniqueNumber = uniqueNumberService.generateUniqueNumber();

        User user = User.builder()
                .personalAccountNumber(uniqueNumber)
                .amountMoney(1000.0)
                .enabled(true)
                .password(encoder.encode(userCreateDto.getPassword()))
                .username(userCreateDto.getUsername())
                .accountTypeId(1L)
                .build();

        User newUser = userRepository.save(user);
        newUser.setAuthorities(setAuthoritiesUser(newUser.getPersonalAccountNumber()));

        try {
            request.login(newUser.getPersonalAccountNumber().toString(), userCreateDto.getPassword());
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
    public Locale getUserLocale(String selectedLanguage) {
        return LocaleUtils.toLocale(selectedLanguage);
    }

    @Override
    public void topUpAccount(TopUpAccountDto topUpAccountDto) {
        User user = userRepository.findByPersonalAccountNumber(topUpAccountDto.getAccountNumber()).get();
        user.setAmountMoney(user.getAmountMoney() + topUpAccountDto.getAmount());
        userRepository.save(user);
    }

}
