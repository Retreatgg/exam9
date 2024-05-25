package com.example.exam9.service.impl;

import com.example.exam9.dto.TransactionDto;
import com.example.exam9.model.Transaction;
import com.example.exam9.repository.TransactionRepository;
import com.example.exam9.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;


    @Override
    public List<TransactionDto> getTransactionByPersonalAccountNumber(Integer personalAccountNumber) {
        List<Transaction> transactions = transactionRepository.findAllByToAccountIdOrFromAccountId(personalAccountNumber, personalAccountNumber);
        List<TransactionDto> list = new ArrayList<>();

        transactions.forEach(t -> {
            list.add(TransactionDto.builder()
                            .id(t.getId())
                            .toAccountId(t.getToAccountId())
                            .fromAccountId(t.getFromAccountId())
                            .amount(t.getAmount())
                            .transactionTime(t.getTransactionTime())
                    .build());
        });

        return list;
    }
}
