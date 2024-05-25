package com.example.exam9.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDto {


    private Long id;



    private Integer fromAccountId;

    private Integer toAccountId;
    private Double amount;

    private String transactionTime;
}
