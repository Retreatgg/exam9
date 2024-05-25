package com.example.exam9.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionSendDto {

    private Integer toAccountNumber;
    private Double amount;
}
