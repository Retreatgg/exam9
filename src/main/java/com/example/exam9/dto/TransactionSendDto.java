package com.example.exam9.dto;

import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionSendDto {

    @Positive
    private Integer toAccountNumber;
    @Positive
    private Double amount;
}
