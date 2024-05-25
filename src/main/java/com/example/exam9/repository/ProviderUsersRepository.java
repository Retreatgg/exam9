package com.example.exam9.repository;


import com.example.exam9.model.Provider;
import com.example.exam9.model.ProviderUsers;
import com.example.exam9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderUsersRepository extends JpaRepository<ProviderUsers, Long> {

    @Query("select pu.accountNumber from ProviderUsers pu where pu.user = :user and pu.provider = :provider")
    Integer findAccountNumberByUserAndProvider(User user, Provider provider);
}
