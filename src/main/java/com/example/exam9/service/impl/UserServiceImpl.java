package com.example.exam9.service.impl;

import com.example.exam9.dto.UserCreateDto;
import com.example.exam9.model.Authority;
import com.example.exam9.model.User;
import com.example.exam9.repository.UserRepository;
import com.example.exam9.service.AuthorityService;
import com.example.exam9.service.EmailService;
import com.example.exam9.service.UserService;
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

    @Override
    public void register(UserCreateDto userCreateDto, HttpServletRequest request) {
        if (isUserExistsByEmail(userCreateDto.getEmail())) {
            throw new IllegalArgumentException("User with email " + userCreateDto.getEmail() + " already exists");
        }

        User user = User.builder()
                .email(userCreateDto.getEmail())
                .enabled(true)
                .password(encoder.encode(userCreateDto.getPassword()))
                .username(userCreateDto.getUsername())
                .accountTypeId(1L)
                .build();

        userRepository.save(user);
        user.setAuthorities(setAuthoritiesUser(user.getEmail()));

        try {
            request.login(userCreateDto.getEmail(), userCreateDto.getPassword());
        } catch (ServletException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<Long> findRolesByEmail(String email) {
        return userRepository.findRolesByEmail(email);
    }

    private boolean isUserExistsByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            return true;
        }
        return false;
    }

    private List<Authority> setAuthoritiesUser(String email) {
        List<Long> roles = findRolesByEmail(email);
        List<Authority> authorities = new ArrayList();
        roles.forEach(u -> {
            authorities.add(authorityService.findById(u));
        });

        return authorities;
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
    public void makeResetPasswdLink(HttpServletRequest request) throws UsernameNotFoundException, UnsupportedEncodingException, MessagingException {
        String email = request.getParameter("email");
        String token = UUID.randomUUID().toString();
        updateResetPasswordToken(token, email);
        String passwordLink = Utility.getSiteURL(request) + "/auth/reset_password?token=" + token;
        emailService.sendEmail(email, passwordLink);
    }


    private void updateResetPasswordToken(String token, String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Could not find any user with the email " + email));
        user.setResetPasswordToken(token);
        userRepository.saveAndFlush(user);
    }



}
