package com.example.exam9.repository;

import com.example.exam9.model.UniqueNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniqueNumberRepository extends JpaRepository<UniqueNumber, Long> {
    boolean existsByUniqueNumber(int uniqueNumber);
}