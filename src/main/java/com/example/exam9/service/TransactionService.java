package com.example.exam9.service;

import com.example.exam9.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    List<TransactionDto> getTransactionByPersonalAccountNumber(Integer personalAccountNumber);
}
