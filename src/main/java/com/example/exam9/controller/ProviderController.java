package com.example.exam9.controller;

import com.example.exam9.dto.PaymentDto;
import com.example.exam9.dto.UserDto;
import com.example.exam9.service.ProviderService;
import com.example.exam9.service.ProviderUsersService;
import com.example.exam9.service.TransactionService;
import com.example.exam9.util.UserUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("provider")
public class ProviderController {

    private final ProviderService providerService;
    private final UserUtil userUtil;
    private final ProviderUsersService providerUsersService;
    private final TransactionService transactionService;

    @GetMapping()
    public String providers(Model model) {
        model.addAttribute("providers", providerService.getProviders());
        return "provider/providers";
    }

    @GetMapping("{id}")
    public String getProvider(@PathVariable Integer id, Model model, Authentication auth) {
        if (auth != null) {
            UserDto user = userUtil.getUserByAuth(auth);
            Integer number = providerUsersService.getUniqueNumber(user.getPersonalAccountNumber(), id);
            if (number != null) {
                model.addAttribute("number", number);
            }
        }

        model.addAttribute("provider", providerService.getProviderById(id));
        return "provider/provider";
    }

    @PostMapping("pay")
    public String pay(Authentication auth, @Valid PaymentDto paymentDto) {
        UserDto user = userUtil.getUserByAuth(auth);
        transactionService.sendTransactionWithProvider(user.getPersonalAccountNumber(), paymentDto);
        return "redirect:/provider/" + paymentDto.getAccountProvider();
    }

    @PostMapping("unique/account")
    public String getUniqueAccount(Authentication auth, @RequestBody Integer providerId, Model model) {
        UserDto user = userUtil.getUserByAuth(auth);
        providerUsersService.createUniqueAccount(user.getPersonalAccountNumber(), providerId);
        return "redirect:/provider/" + providerId;
    }
}
