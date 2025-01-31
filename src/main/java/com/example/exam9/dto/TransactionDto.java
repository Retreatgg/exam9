package com.example.exam9.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDto {

    private Long id;
    private Integer fromAccountId;
    private Integer toProviderId;
    private Integer toAccountId;
    private Double amount;

    private String transactionTime;
}
