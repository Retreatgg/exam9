package com.example.exam9.controller;

import com.example.exam9.dto.TopUpAccountDto;
import com.example.exam9.model.User;
import com.example.exam9.repository.UserRepository;
import com.example.exam9.service.TransactionService;
import com.example.exam9.service.UserService;
import com.example.exam9.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserUtil userUtil;
    private final UserRepository userRepository;
    private final UserService userService;
    private final TransactionService transactionService;

    @GetMapping()
    public String profile(Authentication auth, Model model) {
        User user = userUtil.getUserByAuth(auth);
        model.addAttribute("user", user);
        model.addAttribute("transactions", transactionService.getTransactionByPersonalAccountNumber(user.getPersonalAccountNumber()));
        return "profile/profile";
    }

    @PostMapping("change_language")
    public String changeLanguage(Authentication auth, @RequestBody String lang) {
        if(auth != null) {
            User user = userUtil.getUserByAuth(auth);
            String[] parts = lang.split("=");
            if (parts.length == 2) {
                String paramLang = parts[1];
                user.setSelectedLanguage(paramLang);
                userRepository.save(user);
            }
        }
        return "redirect:/";
    }

    @PostMapping("top_up")
    public String topUpAccount(Authentication authentication, TopUpAccountDto topUpAccountDto) {
        User user = userUtil.getUserByAuth(authentication);
        topUpAccountDto.setAccountNumber(user.getPersonalAccountNumber());
        userService.topUpAccount(topUpAccountDto);
        return "redirect:/profile";
    }
}
