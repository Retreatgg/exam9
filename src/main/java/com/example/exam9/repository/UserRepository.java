package com.example.exam9.repository;

import com.example.exam9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("select u.accountTypeId from User u where u.email like :email")
    List<Long> findRolesByEmail(String email);

    Optional<User> findByResetPasswordToken(String token);;
}
