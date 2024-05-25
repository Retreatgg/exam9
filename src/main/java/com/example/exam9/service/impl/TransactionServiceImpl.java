package com.example.exam9.service.impl;

import com.example.exam9.dto.TransactionDto;
import com.example.exam9.dto.TransactionSendDto;
import com.example.exam9.model.Transaction;
import com.example.exam9.model.User;
import com.example.exam9.repository.TransactionRepository;
import com.example.exam9.repository.UserRepository;
import com.example.exam9.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;


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

    @Override
    public void sendTransaction(TransactionSendDto transactionSendDto, Integer fromAccountNumber) {
        Integer toAccountNumber = transactionSendDto.getToAccountNumber();
        if(userRepository.existsByPersonalAccountNumber(toAccountNumber)) {
            User toUser = userRepository.findByPersonalAccountNumber(toAccountNumber).get();
            User fromUser = userRepository.findByPersonalAccountNumber(fromAccountNumber).get();
            Transaction transaction = Transaction.builder()
                    .transactionTime(LocalDateTime.now())
                    .toAccountId(toAccountNumber)
                    .fromAccountId(fromAccountNumber)
                    .amount(transactionSendDto.getAmount())
                    .build();
            transactionRepository.save(transaction);

            toUser.setAmountMoney(toUser.getAmountMoney() + transactionSendDto.getAmount());
            fromUser.setAmountMoney(fromUser.getAmountMoney() - transactionSendDto.getAmount());
            userRepository.save(toUser);
            userRepository.save(fromUser);
        }

    }
}