package com.example.exam9.controller;

import com.example.exam9.dto.TransactionSendDto;
import com.example.exam9.dto.UserDto;
import com.example.exam9.model.User;
import com.example.exam9.repository.TransactionRepository;
import com.example.exam9.service.TransactionService;
import com.example.exam9.service.UserService;
import com.example.exam9.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;
    private final UserUtil userUtil;

    @PostMapping("send")
    public String sendTransaction(Authentication auth, TransactionSendDto transactionSendDto) {
        UserDto user = userUtil.getUserByAuth(auth);
        transactionService.sendTransaction(transactionSendDto, user.getPersonalAccountNumber());
        return "redirect:/profile";
    }
}
