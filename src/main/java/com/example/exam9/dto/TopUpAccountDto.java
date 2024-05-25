package com.example.exam9.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopUpAccountDto {

    private Integer accountNumber;
    private Double amount;
}
