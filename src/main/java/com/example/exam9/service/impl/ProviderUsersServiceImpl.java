package com.example.exam9.service.impl;

import com.example.exam9.model.Provider;
import com.example.exam9.model.ProviderUsers;
import com.example.exam9.model.User;
import com.example.exam9.repository.ProviderRepository;
import com.example.exam9.repository.ProviderUsersRepository;
import com.example.exam9.repository.UserRepository;
import com.example.exam9.service.ProviderUsersService;
import com.example.exam9.service.UniqueNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderUsersServiceImpl implements ProviderUsersService {

    private final ProviderUsersRepository providerUsersRepository;
    private final UserRepository userRepository;
    private final ProviderRepository providerRepository;
    private final UniqueNumberService uniqueNumberService;


    @Override
    public Integer createUniqueAccount(Integer userId, Integer account) {
        Integer uniqueNumber = uniqueNumberService.generateUniqueNumber();
        ProviderUsers providerUsers = ProviderUsers.builder()
                .user(userRepository.findByPersonalAccountNumber(userId).get())
                .provider(providerRepository.findById(account).get())
                .accountNumber(uniqueNumber)
                .build();

        Integer number = getUniqueNumber(userId, account);
        if(number == null) {
            providerUsersRepository.save(providerUsers);
            return uniqueNumber;
        }

        throw new IllegalArgumentException("you already have an account");
    }

    @Override
    public Integer getUniqueNumber(Integer personalAccountNumber, Integer providerId) {
        User user = userRepository.findByPersonalAccountNumber(personalAccountNumber).get();
        Provider provider = providerRepository.findById(providerId).get();
        return providerUsersRepository.findAccountNumberByUserAndProvider(user, provider);
    }
}
