package com.example.exam9.config;

import com.example.exam9.model.User;
import com.example.exam9.service.UserService;
import com.example.exam9.util.UserUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.LocaleUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private final LocaleResolver localeResolver;
    private final UserService userService;
    private final UserUtil userUtil;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();

        User user = userUtil.getUserByAuth(event.getAuthentication());
        Locale userLocale = LocaleUtils.toLocale("ru");
        if(user.getSelectedLanguage() != null) {
            userLocale = userService.getUserLocale(user.getSelectedLanguage());
        }

        localeResolver.setLocale(request, response, userLocale);
    }
}
