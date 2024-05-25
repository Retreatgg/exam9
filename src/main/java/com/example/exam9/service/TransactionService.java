package com.example.exam9.service;

import com.example.exam9.dto.PaymentDto;
import com.example.exam9.dto.TransactionDto;
import com.example.exam9.dto.TransactionSendDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    List<TransactionDto> getTransactionByPersonalAccountNumber(Integer personalAccountNumber);
    void sendTransaction(TransactionSendDto transactionSendDto, Integer fromAccountNumber);

    void sendTransactionWithProvider(Integer personalAccountNumber, PaymentDto paymentDto);
}
