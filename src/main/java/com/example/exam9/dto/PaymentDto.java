package com.example.exam9.dto;

import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {

    private Long providerId;
    @Positive
    private Integer requisites;
    private Integer accountProvider;

    @Positive
    private Double amount;
}
