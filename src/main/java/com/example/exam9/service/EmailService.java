package com.example.exam9.service;

import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public interface EmailService {

    void sendEmail(String toEmail, String link) throws MessagingException, UnsupportedEncodingException;
}
