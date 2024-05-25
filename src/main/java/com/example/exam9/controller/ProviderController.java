package com.example.exam9.controller;

import com.example.exam9.dto.UserDto;
import com.example.exam9.model.User;
import com.example.exam9.service.ProviderService;
import com.example.exam9.service.ProviderUsersService;
import com.example.exam9.util.UserUtil;
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

    @GetMapping()
    public String providers(Model model) {
        model.addAttribute("providers", providerService.getProviders());
        return "provider/providers";
    }

    @GetMapping("{id}")
    public String getProvider(@PathVariable Long id, Model model, Authentication auth) {
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

    @PostMapping("unique/account")
    public String getUniqueAccount(Authentication auth, @RequestBody Long providerId, Model model) {
        UserDto user = userUtil.getUserByAuth(auth);
        providerUsersService.createUniqueAccount(user.getPersonalAccountNumber(), providerId);
        return "redirect:/provider/" + providerId;
    }
}
