package com.example.exam9.dto;

import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopUpAccountDto {

    @Positive
    private Integer accountNumber;

    @Positive
    private Double amount;
}
