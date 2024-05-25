package com.example.exam9.controller;

import com.example.exam9.dto.TopUpAccountDto;
import com.example.exam9.dto.UserDto;
import com.example.exam9.service.ProviderService;
import com.example.exam9.service.UserService;
import com.example.exam9.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class MainController {

    private final UserUtil userUtil;
    private final UserService userService;

    @GetMapping("")
    public String main(Authentication auth, Model model) {
        if(auth != null) {
            UserDto user = userUtil.getUserByAuth(auth);
            model.addAttribute("user", user);
        }
        return "main/index";
    }


    @PostMapping("anonim/top_up")
    public String topUp(TopUpAccountDto topUpAccountDto) {
        userService.topUpAccount(topUpAccountDto);
        return "redirect:/";
    }
}
