package com.example.exam9.service.impl;

import com.example.exam9.dto.PaymentDto;
import com.example.exam9.dto.TopUpAccountDto;
import com.example.exam9.dto.TransactionDto;
import com.example.exam9.dto.TransactionSendDto;
import com.example.exam9.model.Provider;
import com.example.exam9.model.Transaction;
import com.example.exam9.model.User;
import com.example.exam9.repository.ProviderRepository;
import com.example.exam9.repository.TransactionRepository;
import com.example.exam9.repository.UserRepository;
import com.example.exam9.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProviderRepository providerRepository;
    private final UserRepository userRepository;

    private final DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");

    @Override
    public List<TransactionDto> getTransactionByPersonalAccountNumber(Integer personalAccountNumber) {
        List<Transaction> transactions = transactionRepository.findAllByToAccountIdOrFromAccountId(personalAccountNumber, personalAccountNumber);
        List<TransactionDto> list = new ArrayList<>();

        transactions.forEach(t -> {
            list.add(TransactionDto.builder()
                            .toProviderId(t.getToProviderId())
                            .id(t.getId())
                            .toAccountId(t.getToAccountId())
                            .fromAccountId(t.getFromAccountId())
                            .amount(t.getAmount())
                            .transactionTime(t.getTransactionTime().format(formatters))
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
            if(checkUserBalance(fromUser.getAmountMoney(), transactionSendDto.getAmount())) {
                Transaction transaction = Transaction.builder()
                        .transactionTime(LocalDateTime.now())
                        .toAccountId(toAccountNumber)
                        .fromAccountId(fromAccountNumber)
                        .amount(transactionSendDto.getAmount())
                        .build();
                transactionRepository.save(transaction);
                log.info("The translation was completed successfully");

                toUser.setAmountMoney(toUser.getAmountMoney() + transactionSendDto.getAmount());
                fromUser.setAmountMoney(fromUser.getAmountMoney() - transactionSendDto.getAmount());
                userRepository.save(toUser);
                userRepository.save(fromUser);
            } else {
                String error = "Insufficient funds";
                log.error(error);
                throw new IllegalArgumentException(error);
            }
        }

    }

    @Override
    public void sendTransactionWithProvider(Integer personalAccountNumber, PaymentDto paymentDto) {
        Integer toAccountNumber = paymentDto.getAccountProvider();
        if(providerRepository.existsByAccount(toAccountNumber)) {
            Provider provider = providerRepository.findById(toAccountNumber).get();
            User fromUser = userRepository.findByPersonalAccountNumber(personalAccountNumber).get();
            if(checkUserBalance(fromUser.getAmountMoney(), paymentDto.getAmount())) {
                Transaction transaction = Transaction.builder()
                        .transactionTime(LocalDateTime.now())
                        .toProviderId(toAccountNumber)
                        .fromAccountId(personalAccountNumber)
                        .amount(paymentDto.getAmount())
                        .build();
                transactionRepository.save(transaction);
                log.info("The translation was completed successfully");

                provider.setBalance(provider.getBalance() + paymentDto.getAmount());
                fromUser.setAmountMoney(fromUser.getAmountMoney() - paymentDto.getAmount());
                providerRepository.save(provider);
                userRepository.save(fromUser);
            } else {
                String error = "Insufficient funds";
                log.error(error);
                throw new IllegalArgumentException(error);
            }

        }
    }

    @Override
    public void sendTransactionTerminal(TopUpAccountDto topUpAccountDto) {
        Transaction transaction = Transaction.builder()
                .amount(topUpAccountDto.getAmount())
                .transactionTime(LocalDateTime.now())
                .toAccountId(topUpAccountDto.getAccountNumber())
                .build();

        transactionRepository.save(transaction);
        User user = userRepository.findByPersonalAccountNumber(topUpAccountDto.getAccountNumber()).get();
        user.setAmountMoney(user.getAmountMoney() + topUpAccountDto.getAmount());
        userRepository.save(user);
    }

    private Boolean checkUserBalance(Double userBalance, Double transactionAmount) {
        if(userBalance >= transactionAmount) {
            return true;
        }
        return false;
    }
}
