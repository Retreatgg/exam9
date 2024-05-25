package com.example.exam9.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentDto {

    private Long providerId;
    private Integer requisites;
    private String accountProvider;
    private Double amount;
}
